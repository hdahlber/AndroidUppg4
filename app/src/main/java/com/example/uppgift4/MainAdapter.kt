package com.example.uppgift4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.listofpeople.view.*


class MainAdapter(val humanpeople: Persons) : RecyclerView.Adapter<CustomViewHolder>(){

    override fun getItemCount(): Int{
        //println(humanpeople.persons.count())
        return humanpeople.persons.count()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater=LayoutInflater.from(parent.context)
        val cellForRow=layoutInflater.inflate(R.layout.listofpeople,parent,false)
        return CustomViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val citie= humanpeople.persons[position]
        println(citie.city)
        println(citie.name)
        holder.view.city.text=citie.city
        holder.view.name.text=citie.name

        val thumbnailImageView = holder.view.photo
        Picasso.with(holder.view.context).load(citie.photo).into(thumbnailImageView)





    }
}
class CustomViewHolder(val view: View) :RecyclerView.ViewHolder(view){




}