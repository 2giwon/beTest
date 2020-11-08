package com.egiwon.benxtest.data.entity

import com.google.gson.annotations.SerializedName

data class ShopInfoResponse(
    @SerializedName("artists")
    val artistResponses: List<ArtistResponse>,
    @SerializedName("banners")
    val bannerResponses: List<BannerResponse>,
    @SerializedName("notices")
    val noticeResponses: List<NoticeResponse>,
    @SerializedName("shop")
    val shopResponse: List<ShopResponse>
)