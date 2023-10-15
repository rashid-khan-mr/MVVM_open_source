package com.codingwithjks.mvvmwithromandcoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codingwithjks.mvvmwithromandcoroutines.Adapter.vehicleAdapter
import com.codingwithjks.mvvmwithromandcoroutines.Model.Vehicle

import com.codingwithjks.mvvmwithromandcoroutines.ViewModel.UserViewModel
import com.example.mvvmexample.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var vehicleViewModel: UserViewModel
    private lateinit var dialogBuilder:AlertDialog.Builder
    private lateinit var vehicleDialog: AlertDialog
    private lateinit var vehicleName:EditText
    private lateinit var vehiclePrice:EditText
    private lateinit var saveVehicle:TextView
    private lateinit var recyclerView: RecyclerView
    private lateinit var vehicleAdapter: vehicleAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init(){
        recyclerView=findViewById(R.id.recyclerView)
        vehicleAdapter= vehicleAdapter(this, ArrayList<Vehicle>())
        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager=LinearLayoutManager(this@MainActivity)
            adapter=vehicleAdapter
        }
        vehicleViewModel=ViewModelProvider(this).get(UserViewModel::class.java)
        vehicleViewModel.getAllUserData(this).observe(this, Observer {
            vehicleAdapter.setData(it as ArrayList<Vehicle>)
        })
        findViewById<FloatingActionButton>(R.id.addVehicle).setOnClickListener {
            openVehicleDialog()
        }
    }

    private fun openVehicleDialog() {
        dialogBuilder=AlertDialog.Builder(this)
        var itemView:View=LayoutInflater.from(applicationContext).inflate(R.layout.vehicledialog,null)
        vehicleDialog=dialogBuilder.create()
        vehicleDialog.window!!.setBackgroundDrawableResource(android.R.color.transparent)
        vehicleDialog.setView(itemView)
        vehicleName=itemView.findViewById(R.id.vehiclename)
        vehiclePrice=itemView.findViewById(R.id.vehicleprice)
        saveVehicle=itemView.findViewById(R.id.save)
        saveVehicle.setOnClickListener {
            saveVehicleIntoDatabase()
        }
       vehicleDialog.show()
    }

    private fun saveVehicleIntoDatabase() {
        val getName=vehicleName.text.toString().trim()
        val getPrice=vehiclePrice.text.toString().trim()
        if(!TextUtils.isEmpty(getName) && !TextUtils.isEmpty(getPrice))
        {
            vehicleViewModel.insert(this,Vehicle(getName,Integer.parseInt(getPrice)))
            Toast.makeText(applicationContext,"Vehiccle added successfully..",Toast.LENGTH_SHORT).show()
            vehicleDialog.dismiss()
        }
        else
        {
            Toast.makeText(applicationContext,"Please fill all vehicle data!",Toast.LENGTH_SHORT).show()
        }
    }
}