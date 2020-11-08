package com.egiwon.benxtest.data.entity

import com.google.gson.annotations.SerializedName

data class NoticeResponse(
    @SerializedName("date")
    val date: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("isNew")
    val isNew: Boolean,
    @SerializedName("title")
    val title: String
)