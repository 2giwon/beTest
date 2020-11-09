package com.egiwon.benxtest.data.entity

import com.google.gson.annotations.SerializedName

data class NoticeResponse(
    @SerializedName("date")
    val date: String = "",
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("isNew")
    val isNew: Boolean = false,
    @SerializedName("title")
    val title: String = ""
)