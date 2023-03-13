package com.az.letterlingo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class ItemAdapter(private val allWordsList: ArrayList<String>) :
    RecyclerView.Adapter<ItemAdapter.MyViewHolder>() {

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item,
        parent, false)
        return MyViewHolder(itemView)

    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element

        val currentItem = allWordsList[position]
        holder.tvHeading.text = currentItem

    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount(): Int {

        return allWordsList.size
    }

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder)
     */
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        val tvHeading : TextView = itemView.findViewById(R.id.tvHeading)

    }

}




