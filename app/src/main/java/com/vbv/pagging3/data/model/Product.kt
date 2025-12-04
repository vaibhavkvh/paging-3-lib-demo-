package com.vbv.pagging3.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Product(
    val category: String,
    val description: String,
    val id: Int,
    val thumbnail: String,
    val title: String,
)