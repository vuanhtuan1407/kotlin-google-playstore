package com.example.googleplaystore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val items = arrayListOf<ItemModel>()
        repeat(10) {
            val index = it + 1
            items.add(ItemModel("Item $index",
                resources.getIdentifier("game$index", "drawable", packageName),
                "4.5"))
        }

        val horizontalItems = arrayListOf<HorizontalModel>()
        repeat(10) {
            val index = it + 1
            horizontalItems.add(HorizontalModel("Popular game", items))
        }

        val adapter = HorizontalAdapter(horizontalItems)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view_vertical)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }
}