package com.example.afinal

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val userList : ArrayList<Users>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.user, parent, false)
        return MyViewHolder(itemView)
    }
        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

            val currentItem = userList[position]

            holder.name.text = currentItem.name
            holder.age.text = currentItem.address
            holder.userID.text = currentItem.userID
            holder.num.text = currentItem.num
        }

        override fun getItemCount(): Int {
            return userList.size
        }
        class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

            val num: TextView= itemView.findViewById(R.id.userNum)
            val name : TextView = itemView.findViewById(R.id.userName)
            val age  : TextView = itemView.findViewById(R.id.userAge)
            val userID  : TextView = itemView.findViewById(R.id.userId)

        }

    }