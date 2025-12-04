package com.vbv.pagging3.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface RemoteDao {
    @Query("SELECT * FROM remote_keys where productId=:id")
    suspend fun remoteKeyProductsId(id : Int) : RemoteEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(remoteEntities: List<RemoteEntity>)

    @Query("DELETE from remote_keys")
    suspend fun clearRemoteEntities()
}