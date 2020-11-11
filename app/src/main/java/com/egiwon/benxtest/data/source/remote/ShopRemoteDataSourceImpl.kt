package com.egiwon.benxtest.data.source.remote

import com.egiwon.benxtest.data.entity.ShopInfoResponse
import com.egiwon.benxtest.data.shop.ShopRemoteDataSource
import com.egiwon.benxtest.data.shop.ShopService
import io.reactivex.Single
import javax.inject.Inject

class ShopRemoteDataSourceImpl @Inject constructor(
    private val shopService: ShopService
) : ShopRemoteDataSource {

    override fun loadShopInfo(artistId: Int): Single<ShopInfoResponse> =
        shopService.getShopInfoByArtistId(artistId)

}