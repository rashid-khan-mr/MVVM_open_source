package com.codingwithjks.mvvmwithromandcoroutines.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.codingwithjks.mvvmwithromandcoroutines.Model.Vehicle
import com.example.mvvmexample.R


class vehicleAdapter(private val context: Context, private var vehicleList:ArrayList<Vehicle>) : RecyclerView.Adapter<vehicleAdapter.UserViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.each_item,parent,false))
    }

    override fun getItemCount(): Int =vehicleList.size

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val vehicle:Vehicle=vehicleList[position]
        holder.name.text=vehicle.name
        holder.price.text=vehicle.price.toString()

    }

    fun setData(vehicleList:ArrayList<Vehicle>)
    {
        this.vehicleList=vehicleList
        notifyDataSetChanged()
    }

    inner class UserViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView)
    {
        var name:TextView=itemView.findViewById(R.id.name)
        var price:TextView=itemView.findViewById(R.id.price)
        var delete:ImageView=itemView.findViewById(R.id.delete)
    }
}