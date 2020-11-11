package com.egiwon.benxtest.data.sale.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.egiwon.benxtest.data.sale.entity.SaleEntity
import io.reactivex.Maybe

@Dao
interface RecentSaleDao {

    @Query("SELECT * FROM recentsaleitem WHERE artistId = :id")
    fun getRecentSaleItem(id: Int): Maybe<List<SaleEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRecentSaleItem(recentSaleItem: SaleEntity)
}