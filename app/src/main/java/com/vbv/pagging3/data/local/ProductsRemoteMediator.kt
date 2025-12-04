package com.vbv.pagging3.data.local

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import com.vbv.pagging3.AppDatabase
import com.vbv.pagging3.data.interfaces.ApiService

//@OptIn(ExperimentalPagingApi::class)
//class ProductsRemoteMediator (private val apiService: ApiService, private val appDatabase: AppDatabase)
//    : RemoteMediator<Int, ProductEntity>(){
//
//    override suspend fun load(
//        loadType: LoadType,
//        state: PagingState<Int, ProductEntity>
//    ): MediatorResult {
//        val page
//    }
//
//}