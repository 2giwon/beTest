package com.egiwon.benxtest.data.source.local

import com.egiwon.benxtest.data.sale.ShopLocalDataSource
import com.egiwon.benxtest.data.sale.database.RecentSaleDao
import com.egiwon.benxtest.data.sale.entity.SaleEntity
import io.reactivex.Single
import javax.inject.Inject

class ShopLocalDataSourceImpl @Inject constructor(
    private val recentSaleDao: RecentSaleDao
) : ShopLocalDataSource {

    override fun loadRecentlySaleItems(artistId: Int): Single<List<SaleEntity>> =
        recentSaleDao.getRecentSaleItem(artistId)
            .toSingle()
            .onErrorReturn { emptyList() }

    override fun insertRecentSaleItem(recentSaleItem: SaleEntity) =
        recentSaleDao.insertRecentSaleItem(recentSaleItem)


}