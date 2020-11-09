package com.egiwon.benxtest.data.entity

import com.google.gson.annotations.SerializedName

data class ArtistResponse(
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("imageUrl")
    val imageUrl: String = "",
    @SerializedName("name")
    val name: String = "",
    @SerializedName("shops")
    val shops: List<String> = emptyList()
)