package com.egiwon.benxtest.data.entity

import com.google.gson.annotations.SerializedName

data class CategoryResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
)