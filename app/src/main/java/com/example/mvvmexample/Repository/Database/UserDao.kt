package com.example.mvvmexample

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
   suspend fun insert(vehicle:Vehicle)

   @Insert(onConflict = OnConflictStrategy.REPLACE)
   suspend fun delete(vehicle:Vehicle)

    @Query("SELECT * FROM vehicle ORDER BY id ASC")
    fun getAllUserData():LiveData<List<Vehicle>>
}