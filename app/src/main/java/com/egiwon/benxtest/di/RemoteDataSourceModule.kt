package com.egiwon.benxtest.di

import com.egiwon.benxtest.data.shop.ShopDataSource
import com.egiwon.benxtest.data.shop.ShopService
import com.egiwon.benxtest.data.source.ShopRemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class RemoteDataSourceModule {

    @Provides
    @Singleton
    fun provideShopRemoteDataSource(shopService: ShopService): ShopDataSource =
        ShopRemoteDataSource(shopService)
}