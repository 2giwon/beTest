package com.egiwon.benxtest.data.entity

import com.google.gson.annotations.SerializedName

data class ShopInfoResponse(
    @SerializedName("artists")
    val artistResponses: List<ArtistResponse> = emptyList(),
    @SerializedName("banners")
    val bannerResponses: List<BannerResponse> = emptyList(),
    @SerializedName("notices")
    val noticeResponses: List<NoticeResponse> = emptyList(),
    @SerializedName("shop")
    val shopResponse: List<ShopResponse> = emptyList()
)