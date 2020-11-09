package com.egiwon.benxtest.data.entity

import com.google.gson.annotations.SerializedName

data class BannerResponse(
    @SerializedName("imageUrl")
    val imageUrl: String = "",
    @SerializedName("subTitle")
    val subTitle: String = "",
    @SerializedName("title")
    val title: String = ""
)