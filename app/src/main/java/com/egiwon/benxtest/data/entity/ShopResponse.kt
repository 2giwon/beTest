package com.egiwon.benxtest.data.entity

import com.google.gson.annotations.SerializedName

data class ShopResponse(
    @SerializedName("category")
    val categoryResponse: CategoryResponse,
    @SerializedName("sales")
    val saleResponses: List<SaleResponse>
)