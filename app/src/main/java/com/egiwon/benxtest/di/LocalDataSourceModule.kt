package com.egiwon.benxtest.di

import android.content.Context
import androidx.room.Room
import com.egiwon.benxtest.data.sale.ShopLocalDataSource
import com.egiwon.benxtest.data.sale.database.RecentSaleDao
import com.egiwon.benxtest.data.sale.database.ShopDataBase
import com.egiwon.benxtest.data.source.local.ShopLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class LocalDataSourceModule {

    @Provides
    @Singleton
    fun provideDataBase(
        @ApplicationContext context: Context
    ): ShopDataBase =
        Room.databaseBuilder(
            context,
            ShopDataBase::class.java,
            ShopDataBase.DB_NAME
        ).build()

    @Provides
    @Singleton
    fun provideDao(
        shopDataBase: ShopDataBase
    ): RecentSaleDao = shopDataBase.recentSaleDao()

    @Provides
    @Singleton
    fun provideLocalDataSource(
        recentSaleDao: RecentSaleDao
    ): ShopLocalDataSource = ShopLocalDataSourceImpl(recentSaleDao)
}