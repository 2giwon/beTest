package com.egiwon.benxtest.data.entity

import com.google.gson.annotations.SerializedName

data class ShopResponse(
    @SerializedName("category")
    val categoryResponse: CategoryResponse = CategoryResponse(),
    @SerializedName("sales")
    val saleResponses: List<SaleResponse> = emptyList()
)