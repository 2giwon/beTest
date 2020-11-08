package com.egiwon.benxtest.shop.model

import com.egiwon.benxtest.data.entity.CategoryResponse

data class Category(
    val id: Int = 0,
    val name: String = ""
)

fun CategoryResponse.mapToCategory(): Category =
    Category(id, name)