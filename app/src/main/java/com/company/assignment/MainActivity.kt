package com.company.assignment

import ExpandableCardAdapter
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       // Find the RecyclerView in your layout and set the padding
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val dpPadding = calculatePadding(this) // Pass the context

        recyclerView.setPadding(0, dpPadding, 0, 0)
        recyclerView.requestLayout()

        recyclerView.layoutManager = LinearLayoutManager(this)

        val cardDataList = mutableListOf(
            CardData("Personal", "If You want to network with the community, use other service on the app, chat,amke free audio and video calls, join as PERSONAL User"),
            CardData("Buisness", "World's Largest real time service community"),
            CardData("Merchant", "World's Largest real time merchant's community")
        )

        val adapter = ExpandableCardAdapter(cardDataList, this)
        recyclerView.adapter = adapter
    }

    private fun calculatePadding(context: Context): Int {
        // Calculate the desired padding based on a fraction of the screen height
        val screenHeight = context.resources.displayMetrics.heightPixels
        val paddingFraction = 0.7 // Adjust this fraction as needed
        val desiredPadding = (screenHeight * paddingFraction).toInt()

        // Convert the padding from pixels to dp
        return (desiredPadding / context.resources.displayMetrics.density).toInt()
    }
}