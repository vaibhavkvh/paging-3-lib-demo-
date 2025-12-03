package com.vbv.pagging3.data.interfaces

import com.vbv.pagging3.data.model.Product
import com.vbv.pagging3.data.model.ProductsResponse
import retrofit2.http.GET

interface ApiService {
    @GET("/products")
    suspend fun getProducts(): ProductsResponse

}