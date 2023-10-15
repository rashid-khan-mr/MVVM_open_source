package com.codingwithjks.mvvmwithromandcoroutines.Dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.codingwithjks.mvvmwithromandcoroutines.Model.Vehicle

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
   suspend fun insert(vehicle:Vehicle)

   @Insert(onConflict = OnConflictStrategy.REPLACE)
   suspend fun delete(vehicle:Vehicle)

    @Query("SELECT * FROM vehicle ORDER BY id ASC")
    fun getAllUserData():LiveData<List<Vehicle>>
}