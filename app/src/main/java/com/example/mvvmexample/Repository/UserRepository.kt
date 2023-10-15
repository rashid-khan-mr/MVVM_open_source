package com.example.mvvmexample

import android.content.Context
import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class UserRepository {

    companion object{
        var userDatabase:UserDatabase?=null

        private fun intialiseDB(context:Context): UserDatabase?
        {
            return UserDatabase.getInstance(context)!!
        }

        fun insert(context: Context, vehicle:Vehicle)
        {
            userDatabase= intialiseDB(context)

            CoroutineScope(IO).launch {
                userDatabase!!.userDao().insert(vehicle)
                userDatabase!!.userDao().insert(vehicle)
            }
        }

        fun getAllUserData(context: Context): LiveData<List<Vehicle>>
        {
            userDatabase= intialiseDB(context)
            return userDatabase!!.userDao().getAllUserData()
        }
    }
}