package com.vbv.pagging3

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.vbv.pagging3.data.local.ProductEntity
import com.vbv.pagging3.data.local.ProductsDao
import com.vbv.pagging3.data.local.RemoteDao
import com.vbv.pagging3.data.local.RemoteEntity

@Database(entities = [ProductEntity::class, RemoteEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase(){
    abstract fun productsDao() : ProductsDao
    abstract fun remoteDao() : RemoteDao
    companion object{
        @Volatile
        private var Instance : AppDatabase?=null

        fun getDatabase(context: Context): AppDatabase{
            return Instance?: synchronized(this){
                Room.databaseBuilder(context, AppDatabase::class.java,"procuts_db")
                    .build()
                    .also { Instance = it }
            }
        }

    }
}