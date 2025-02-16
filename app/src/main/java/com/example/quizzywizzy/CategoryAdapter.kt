package com.example.quizzywizzy

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CategoryAdapter(private val categories: List<Category>) :
        RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {
                inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
                        val btnCategory: Button = itemView.findViewById(R.id.btnCategory)
                }


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
                val view = LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_category, parent, false)
                return ViewHolder(view)
        }
        var onItemClick: ((Category) -> Unit)? = null
        // Bind data to views - THIS WAS MISSING
        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
                val category = categories[position] // Get the category at current position
                holder.btnCategory.text = category.title // Set button text

                holder.btnCategory.setOnClickListener {
                        onItemClick?.invoke(category) // Pass the actual category object
                }
        }

        // Return total items count
        override fun getItemCount() = categories.size
}