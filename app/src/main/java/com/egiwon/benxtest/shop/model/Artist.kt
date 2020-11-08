package com.egiwon.benxtest.shop.model

import com.egiwon.benxtest.data.entity.ArtistResponse

data class Artist(
    val id: Int = 0,
    val imageUrl: String = "",
    val name: String = "",
    val shops: List<String> = emptyList()
)

fun ArtistResponse.mapToArtist(): Artist =
    Artist(
        id = id,
        imageUrl = imageUrl,
        name = name,
        shops = shops
    )