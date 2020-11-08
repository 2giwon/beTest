package com.egiwon.benxtest.data.shop

import com.egiwon.benxtest.data.ShopRepository
import com.egiwon.benxtest.data.entity.ShopInfoResponse
import io.reactivex.Single
import javax.inject.Inject

class ShopRepositoryImpl @Inject constructor(
    private val remoteDataSource: ShopDataSource
) : ShopRepository {

    override fun loadShopInfo(artistId: Int): Single<ShopInfoResponse> =
        remoteDataSource.loadShopInfo(artistId)

}