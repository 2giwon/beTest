package com.egiwon.benxtest.data.shop

import com.egiwon.benxtest.data.entity.ShopInfoResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface ShopService {

    @GET("shop/{id}")
    fun getShopInfoByArtistId(@Path("id") artistId: Int): Single<ShopInfoResponse>
}