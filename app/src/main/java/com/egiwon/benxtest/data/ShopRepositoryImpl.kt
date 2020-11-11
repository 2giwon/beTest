package com.egiwon.benxtest.data

import com.egiwon.benxtest.data.entity.ShopInfoResponse
import com.egiwon.benxtest.data.sale.ShopLocalDataSource
import com.egiwon.benxtest.data.sale.entity.SaleEntity
import com.egiwon.benxtest.data.shop.ShopRemoteDataSource
import io.reactivex.Single
import javax.inject.Inject

class ShopRepositoryImpl @Inject constructor(
    private val remoteRemoteDataSource: ShopRemoteDataSource,
    private val localDataSource: ShopLocalDataSource
) : ShopRepository {

    override fun loadShopInfo(artistId: Int): Single<ShopInfoResponse> =
        remoteRemoteDataSource.loadShopInfo(artistId)

    override fun loadRecentSaleItem(artistId: Int): Single<List<SaleEntity>> =
        localDataSource.loadRecentlySaleItems(artistId)

    override fun insertRecentSaleItem(recentSaleItem: SaleEntity) =
        localDataSource.insertRecentSaleItem(recentSaleItem)

}