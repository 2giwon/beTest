package com.egiwon.benxtest.di

import com.egiwon.benxtest.data.ShopRepository
import com.egiwon.benxtest.data.shop.ShopDataSource
import com.egiwon.benxtest.data.shop.ShopRepositoryImpl
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
    fun provideShopRepository(shopDataSource: ShopDataSource): ShopRepository =
        ShopRepositoryImpl(shopDataSource)
}