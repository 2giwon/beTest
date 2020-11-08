package com.egiwon.benxtest.data.entity

import com.google.gson.annotations.SerializedName

data class SaleResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("imageUrl")
    val imageUrl: String,
    @SerializedName("isFcOnly")
    val isFcOnly: Boolean,
    @SerializedName("isMonopoly")
    val isMonopoly: Boolean,
    @SerializedName("isPreOrder")
    val isPreOrder: Boolean,
    @SerializedName("isSoldOut")
    val isSoldOut: Boolean,
    @SerializedName("name")
    val name: String,
    @SerializedName("originalPrice")
    val originalPrice: Int,
    @SerializedName("salePrice")
    val salePrice: Int
)