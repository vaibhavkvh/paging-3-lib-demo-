package com.vbv.pagging3.data.local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query

@Dao
interface ProductsDao{
    @Query("SELECT * FROM PRODUCTS")
    fun getAllProducts() : PagingSource<Int, ProductEntity>

    @Insert(onConflict = REPLACE)
    suspend fun insertAll(products : List<ProductEntity>)

    @Query("DELETE FROM PRODUCTS")
    suspend fun clearAll()
}