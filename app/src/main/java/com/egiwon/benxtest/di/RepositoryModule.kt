package com.egiwon.benxtest.di

import com.egiwon.benxtest.data.ShopRepository
import com.egiwon.benxtest.data.ShopRepositoryImpl
import com.egiwon.benxtest.data.sale.ShopLocalDataSource
import com.egiwon.benxtest.data.shop.ShopRemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideShopRepository(
        shopRemoteDataSource: ShopRemoteDataSource,
        shopLocalDataSource: ShopLocalDataSource
    ): ShopRepository =
        ShopRepositoryImpl(shopRemoteDataSource, shopLocalDataSource)
}