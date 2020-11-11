package com.egiwon.benxtest.data

import com.egiwon.benxtest.data.entity.ShopInfoResponse
import com.egiwon.benxtest.data.sale.entity.SaleEntity
import io.reactivex.Single

interface ShopRepository {

    fun loadShopInfo(artistId: Int): Single<ShopInfoResponse>

    fun loadRecentSaleItem(artistId: Int): Single<List<SaleEntity>>

    fun insertRecentSaleItem(recentSaleItem: SaleEntity)
}