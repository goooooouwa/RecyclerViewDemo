package com.example.recyclerviewdemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MyRecyclerViewAdaptor(
    private val fruitsList: List<Fruit>,
    private val clickListener: (Fruit)->Unit
    ): RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItem = layoutInflater.inflate(R.layout.list_item, parent, false)
        return MyViewHolder(listItem)
    }

    override fun getItemCount(): Int {
        return fruitsList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val fruit = fruitsList[position]
        holder.bind(fruit, clickListener)
    }

}

class MyViewHolder(val view: View): RecyclerView.ViewHolder(view){
    fun bind(fruit: Fruit, clickListener:(Fruit) -> Unit){
        val myTextView = view.findViewById<TextView>(R.id.tvName)
        myTextView.text = fruit.name

        view.setOnClickListener{
            clickListener(fruit)
        }
    }
}

