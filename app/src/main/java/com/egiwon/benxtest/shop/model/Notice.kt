package com.egiwon.benxtest.shop.model

import com.egiwon.benxtest.data.entity.NoticeResponse

data class Notice(
    val date: String = "",
    val id: Int = 0,
    val isNew: Boolean = false,
    val title: String = ""
)

fun NoticeResponse.mapToNotice(): Notice =
    Notice(
        date = date,
        id = id,
        isNew = isNew,
        title = title
    )