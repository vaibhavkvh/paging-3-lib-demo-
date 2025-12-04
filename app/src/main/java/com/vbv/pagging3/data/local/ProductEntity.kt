package com.vbv.pagging3.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
data class ProductEntity(
    val category: String,
    val description: String,
    @PrimaryKey
    val id: Int,
    val thumbnail: String,
    val title: String,
)