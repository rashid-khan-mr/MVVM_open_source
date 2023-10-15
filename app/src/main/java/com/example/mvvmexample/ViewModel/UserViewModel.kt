package com.example.mvvmexample

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
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