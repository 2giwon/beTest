package com.egiwon.benxtest.shop.model

import com.egiwon.benxtest.data.entity.BannerResponse

data class Banner(
    val imageUrl: String = "",
    val subTitle: String = "",
    val title: String = ""
)

fun BannerResponse.mapToBanner(): Banner =
    Banner(
        imageUrl = imageUrl,
        subTitle = subTitle,
        title = title
    )
