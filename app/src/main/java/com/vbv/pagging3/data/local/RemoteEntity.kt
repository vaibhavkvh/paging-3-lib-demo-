package com.vbv.pagging3.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "remote_keys")
data class RemoteEntity(
    @PrimaryKey
    val productId : Int,
    val prevKey : Int?,
    val nextKey : Int?
)