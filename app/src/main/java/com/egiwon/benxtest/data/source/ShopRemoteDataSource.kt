package com.egiwon.benxtest.data.source

import com.egiwon.benxtest.data.entity.ShopInfoResponse
import com.egiwon.benxtest.data.shop.ShopDataSource
import com.egiwon.benxtest.data.shop.ShopService
import io.reactivex.Single
import javax.inject.Inject

class ShopRemoteDataSource @Inject constructor(
    private val shopService: ShopService
) : ShopDataSource {

    override fun loadShopInfo(artistId: Int): Single<ShopInfoResponse> =
        shopService.getShopInfoByArtistId(artistId)

}