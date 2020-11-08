package com.egiwon.benxtest.shop.model

import com.egiwon.benxtest.data.entity.SaleResponse

data class SaleItem(
    val id: Int = 0,
    val imageUrl: String = "",
    val isFcOnly: Boolean = false,
    val isMonopoly: Boolean = false,
    val isPreOrder: Boolean = false,
    val isSoldOut: Boolean = false,
    val name: String = "",
    val originalPrice: Int = 0,
    val salePrice: Int = 0
)

fun SaleResponse.mapToSaleItem(): SaleItem =
    SaleItem(
        id = id,
        imageUrl = imageUrl,
        isFcOnly = isFcOnly,
        isMonopoly = isMonopoly,
        isPreOrder = isPreOrder,
        isSoldOut = isSoldOut,
        name = name,
        originalPrice = originalPrice,
        salePrice = salePrice
    )