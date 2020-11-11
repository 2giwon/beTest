package com.egiwon.benxtest.data.sale.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.egiwon.benxtest.data.sale.entity.SaleEntity

@Database(entities = [SaleEntity::class], version = 1, exportSchema = false)
abstract class ShopDataBase : RoomDatabase() {
    abstract fun recentSaleDao(): RecentSaleDao

    companion object {
        const val DB_NAME = "RecentSaleItems.db"
    }
}