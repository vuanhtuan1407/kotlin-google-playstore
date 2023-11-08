package com.example.googleplaystore

import android.content.ClipData
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HorizontalAdapter(val items: ArrayList<HorizontalModel>):
    RecyclerView.Adapter<HorizontalAdapter.RVItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVItemViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.horizontal_list, parent, false)
        return RVItemViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RVItemViewHolder, position: Int) {
        holder.titleHorizontal.text = items[position].titleHorizontal
        holder.bindRecyclerView(items[position].itemsHorizontal)
    }

    inner class RVItemViewHolder(val itemView: View): RecyclerView.ViewHolder(itemView) {
        var titleHorizontal: TextView = itemView.findViewById(R.id.title)

        fun bindRecyclerView(items: ArrayList<ItemModel>){
            val itemsHorizontal: RecyclerView = itemView.findViewById(R.id.recycler_view_horizontal)

            val manager : RecyclerView.LayoutManager =
                LinearLayoutManager(itemView.context, LinearLayoutManager.HORIZONTAL, false)
            itemsHorizontal.apply{
                var myAdapter = ItemAdapter(items)
                layoutManager = manager
                adapter = myAdapter
            }
        }
    }
}