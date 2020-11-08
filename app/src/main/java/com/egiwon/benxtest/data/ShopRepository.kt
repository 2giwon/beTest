package com.egiwon.benxtest.data

import com.egiwon.benxtest.data.entity.ShopInfoResponse
import io.reactivex.Single

interface ShopRepository {

    fun loadShopInfo(artistId: Int): Single<ShopInfoResponse>
}