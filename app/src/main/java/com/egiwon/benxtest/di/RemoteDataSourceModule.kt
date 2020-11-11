package com.egiwon.benxtest.di

import com.egiwon.benxtest.data.shop.ShopRemoteDataSource
import com.egiwon.benxtest.data.shop.ShopService
import com.egiwon.benxtest.data.source.remote.ShopRemoteDataSourceImpl
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
    fun provideShopRemoteDataSource(shopService: ShopService): ShopRemoteDataSource =
        ShopRemoteDataSourceImpl(shopService)
}