package com.egiwon.benxtest.data.entity

import com.google.gson.annotations.SerializedName

data class SaleResponse(
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("imageUrl")
    val imageUrl: String = "",
    @SerializedName("isFcOnly")
    val isFcOnly: Boolean = false,
    @SerializedName("isMonopoly")
    val isMonopoly: Boolean = false,
    @SerializedName("isPreOrder")
    val isPreOrder: Boolean = false,
    @SerializedName("isSoldOut")
    val isSoldOut: Boolean = false,
    @SerializedName("name")
    val name: String = "",
    @SerializedName("originalPrice")
    val originalPrice: Int = 0,
    @SerializedName("salePrice")
    val salePrice: Int = 0
)