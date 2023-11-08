package com.example.googleplaystore

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter(val items: ArrayList<ItemModel>): RecyclerView.Adapter<ItemAdapter.RVItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVItemViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item, parent, false)
        return RVItemViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RVItemViewHolder, position: Int) {
        holder.title.text = items[position].title
        holder.avatar.setImageResource(items[position].avatar)
        holder.rate.text = items[position].rate
    }

    class RVItemViewHolder(val itemView: View): RecyclerView.ViewHolder(itemView) {
        val title: TextView
        val avatar: ImageView
        val rate: TextView
        init {
            title = itemView.findViewById(R.id.titleGame)
            avatar = itemView.findViewById(R.id.avatar)
            rate = itemView.findViewById(R.id.rate)
        }
    }
}