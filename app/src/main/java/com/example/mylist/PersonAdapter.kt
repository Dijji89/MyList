package com.example.mylist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PersonAdapter (var persons: List<Person>, var activity: MainActivity):RecyclerView.Adapter<PersonAdapter.PersonViewHolder>(){
    class PersonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val imgPhoto = itemView.findViewById<ImageView>(R.id.imagePhoto)
        val tvName = itemView.findViewById<TextView>(R.id.TextName)
        val tvSName = itemView.findViewById<TextView>(R.id.TextSName)
        val tvPhone = itemView.findViewById<TextView>(R.id.TextPhone)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        val holder = PersonViewHolder(itemView)
        holder.itemView.setOnClickListener{
            activity.onItemClick(holder.adapterPosition)
        }
        holder.itemView.setOnLongClickListener {
            activity.deleteItem(holder.adapterPosition)
            return@setOnLongClickListener true
        }

        return holder
    }

    override fun getItemCount(): Int {
       return persons.size
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        val currPerson = persons[position]

        holder.tvName.text = currPerson.name
        holder.tvSName.text =currPerson.sName
        holder.tvPhone.text = currPerson.phone
        holder.imgPhoto.setImageResource(currPerson.photoID)
    }
}