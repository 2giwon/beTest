package com.egiwon.benxtest.shop.model

import android.os.Parcelable
import com.egiwon.benxtest.data.entity.ArtistResponse
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Artist(
    val id: Int = 0,
    val imageUrl: String = "",
    val name: String = "",
    val shops: List<String> = emptyList()
) : Parcelable

fun ArtistResponse.mapToArtist(): Artist =
    Artist(
        id = id,
        imageUrl = imageUrl,
        name = name,
        shops = shops
    )