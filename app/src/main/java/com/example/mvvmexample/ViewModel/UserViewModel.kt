package com.codingwithjks.mvvmwithromandcoroutines.ViewModel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.codingwithjks.mvvmwithromandcoroutines.Model.Vehicle
import com.codingwithjks.mvvmwithromandcoroutines.Repository.UserRepository

class UserViewModel :ViewModel() {

    fun insert(context: Context, vehicle:Vehicle)
    {
        UserRepository.insert(context,vehicle)
    }

    fun getAllUserData(context: Context):LiveData<List<Vehicle>>
    {
        return UserRepository.getAllUserData(context)
    }
}