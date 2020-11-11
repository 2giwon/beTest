package com.egiwon.benxtest.shop

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.egiwon.benxtest.R
import com.egiwon.benxtest.base.BaseViewModel
import com.egiwon.benxtest.data.ShopRepository
import com.egiwon.benxtest.data.entity.ShopInfoResponse
import com.egiwon.benxtest.data.sale.entity.SaleEntity
import com.egiwon.benxtest.data.sale.entity.mapToSaleEntity
import com.egiwon.benxtest.shop.model.Artist
import com.egiwon.benxtest.shop.model.Banner
import com.egiwon.benxtest.shop.model.Notice
import com.egiwon.benxtest.shop.model.SaleItem
import com.egiwon.benxtest.shop.model.ShopInfo
import com.egiwon.benxtest.shop.model.ShopItem
import com.egiwon.benxtest.shop.model.mapToSaleItem
import com.egiwon.benxtest.shop.model.mapToShopInfo
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class ShopViewModel @ViewModelInject constructor(
    private val repository: ShopRepository
) : BaseViewModel() {

    private val _loadingBar = MutableLiveData<Boolean>()
    val loadingBar: LiveData<Boolean> get() = _loadingBar

    private val _artistId = MutableLiveData<Int>()
    val artistId: LiveData<Int> get() = _artistId

    private val _banners = MutableLiveData<List<Banner>>()
    val banners: LiveData<List<Banner>> get() = _banners

    private val _shopItems = MutableLiveData<List<ShopItem>>()
    val shopItems: LiveData<List<ShopItem>> get() = _shopItems

    private val _mapSaleItems = MutableLiveData<Map<Int, List<SaleItem>>>()
    val mapSaleItems: LiveData<Map<Int, List<SaleItem>>> get() = _mapSaleItems

    private val _noticeItems = MutableLiveData<List<Notice>>()
    val noticeItems: LiveData<List<Notice>> get() = _noticeItems

    private val _artists = MutableLiveData<List<Artist>>()
    val artists: LiveData<List<Artist>> get() = _artists

    private val _recentSelectedSaleItems = MutableLiveData<List<SaleItem>>()
    val recentSelectedSaleItems: LiveData<List<SaleItem>> get() = _recentSelectedSaleItems

    private val _isShowRecentSelectedItems = MutableLiveData<Boolean>()
    val isShowRecentSelectedItem: LiveData<Boolean> get() = _isShowRecentSelectedItems

    private var _shopInfo: ShopInfo = ShopInfo()

    private val _map = HashMap<Int, List<SaleItem>>()

    private var _currentArtistId = BTS

    fun loadShopInfo() {
        repository.loadShopInfo(_currentArtistId)
            .doOnSubscribe { _loadingBar.postValue(true) }
            .doAfterTerminate { _loadingBar.postValue(false) }
            .subscribeOn(Schedulers.io())
            .map(ShopInfoResponse::mapToShopInfo)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onSuccess = {
                    _shopInfo = it
                    _banners.value = it.banners
                    _shopItems.value = it.shopItems
                    _noticeItems.value = it.notices
                    findCurrentArtist(it.artist, _currentArtistId)
                    getRecentlySelectedSaleItem()
                },
                onError = { toastMessageMutableLiveData.value = R.string.error_load_fail_shop_info }
            )
            .addTo(compositeDisposable)
    }

    fun loadShopInfo(artistId: Int) {
        _currentArtistId = artistId
        loadShopInfo()
    }

    private fun findCurrentArtist(artists: List<Artist>, artistId: Int) {
        _artistId.value = artists.find { it.id == artistId }?.id
    }

    fun getShopItems(categoryId: Int) {
        if (_shopItems.value != null) {
            val list: List<ShopItem> = requireNotNull(_shopItems.value)

            for (shopItem: ShopItem in list) {
                if (shopItem.category.id == categoryId) {
                    _map[categoryId] = shopItem.saleItems
                    _mapSaleItems.value = _map
                }
            }
        }
    }

    private fun getRecentlySelectedSaleItem() {
        repository.loadRecentSaleItem(_currentArtistId)
            .subscribeOn(Schedulers.io())
            .map { it.map(SaleEntity::mapToSaleItem) }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onSuccess = {
                    _recentSelectedSaleItems.value = it
                    _isShowRecentSelectedItems.value = it.isNotEmpty()
                },
                onError = {
                    toastMessageMutableLiveData.value =
                        R.string.error_load_recently_selected_sale_items
                }
            )
            .addTo(compositeDisposable)
    }

    fun requestAddRecentlySelectedSaleItem(saleItem: SaleItem) {
        Single.fromCallable {
            repository.insertRecentSaleItem(saleItem.mapToSaleEntity(_currentArtistId))
        }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()
            .addTo(compositeDisposable)
    }


    fun getArtists() {
        _artists.value = _shopInfo.artist
    }

    companion object {
        const val BTS = 1
    }
}