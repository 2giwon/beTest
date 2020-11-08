package com.egiwon.benxtest.shop.model

import com.egiwon.benxtest.data.entity.SaleResponse
import com.egiwon.benxtest.data.entity.ShopResponse

data class ShopItem(
    val category: Category,
    val saleItems: List<SaleItem> = emptyList()
)

fun ShopResponse.mapToShopItem(): ShopItem =
    ShopItem(
        category = categoryResponse.mapToCategory(),
        saleItems = saleResponses.map(SaleResponse::mapToSaleItem)
    )