package com.egiwon.benxtest.data.sale

import com.egiwon.benxtest.data.sale.entity.SaleEntity
import io.reactivex.Single

interface ShopLocalDataSource {

    fun loadRecentlySaleItems(artistId: Int): Single<List<SaleEntity>>

    fun insertRecentSaleItem(recentSaleItem: SaleEntity)
}