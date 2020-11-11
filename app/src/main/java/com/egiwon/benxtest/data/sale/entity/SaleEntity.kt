package com.egiwon.benxtest.data.sale.entity

import androidx.room.Entity
import com.egiwon.benxtest.shop.model.SaleItem

@Entity(tableName = "recentsaleitem", primaryKeys = ["artistId", "id"])
data class SaleEntity(
    val artistId: Int = 0,
    val id: Int = 0,
    val imageUrl: String = "",
    val isFcOnly: Boolean = false,
    val isMonopoly: Boolean = false,
    val isPreOrder: Boolean = false,
    val isSoldOut: Boolean = false,
    val name: String = "",
    val originalPrice: Int = 0,
    val salePrice: Int = 0,
    val createTime: Long = 0
)

fun SaleItem.mapToSaleEntity(artistId: Int): SaleEntity =
    SaleEntity(
        artistId = artistId,
        id = id,
        imageUrl = imageUrl,
        isFcOnly = isFcOnly,
        isMonopoly = isMonopoly,
        isPreOrder = isPreOrder,
        isSoldOut = isSoldOut,
        name = name,
        originalPrice = originalPrice,
        salePrice = salePrice,
        createTime = System.currentTimeMillis()
    )