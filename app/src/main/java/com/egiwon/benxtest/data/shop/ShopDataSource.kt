package com.egiwon.benxtest.data.shop

import com.egiwon.benxtest.data.entity.ShopInfoResponse
import io.reactivex.Single

interface ShopDataSource {

    fun loadShopInfo(artistId: Int): Single<ShopInfoResponse>

}