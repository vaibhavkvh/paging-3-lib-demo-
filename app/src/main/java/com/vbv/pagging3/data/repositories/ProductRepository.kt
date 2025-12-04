package com.vbv.pagging3.data.repositories

import com.vbv.pagging3.data.interfaces.ApiService
import com.vbv.pagging3.data.model.ProductsResponse

class ProductRepository(private val apiService: ApiService) {

    suspend fun getProducts() : ProductsResponse = apiService.getProducts()
}