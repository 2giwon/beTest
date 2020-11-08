package com.egiwon.benxtest.shop.model

import com.egiwon.benxtest.data.entity.*

data class ShopInfo(
    val artist: List<Artist> = emptyList(),
    val banners: List<Banner> = emptyList(),
    val notices: List<Notice> = emptyList(),
    val shopItems: List<ShopItem> = emptyList()
)

fun ShopInfoResponse.mapToShopInfo(): ShopInfo = ShopInfo(
    artist = artistResponses.map(ArtistResponse::mapToArtist),
    banners = bannerResponses.map(BannerResponse::mapToBanner),
    notices = noticeResponses.map(NoticeResponse::mapToNotice),
    shopItems = shopResponse.map(ShopResponse::mapToShopItem)
)
