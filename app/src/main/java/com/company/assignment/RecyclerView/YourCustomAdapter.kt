package com.company.assignment.RecyclerView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.company.assignment.R
import com.company.assignment.Section1Data
import com.company.assignment.Section2Data
import com.company.assignment.Section3Data

class YourCustomAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    // Define different data sets for each section
    private val section1Data = mutableListOf<Section1Data>()
    private val section2Data = mutableListOf<Section2Data>()
    private val section3Data = mutableListOf<Section3Data>()

    // Track the current section that should be displayed
    private var currentSection: Int = 1

    // Custom view types for different sections
    private val VIEW_TYPE_SECTION_1 = 1
    private val VIEW_TYPE_SECTION_2 = 2
    private val VIEW_TYPE_SECTION_3 = 3

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            VIEW_TYPE_SECTION_1 -> {
                // Create and return view holders for Section 1
                val view = LayoutInflater.from(parent.context).inflate(R.layout.cards, parent, false)
                return Section1ViewHolder(view)
            }
            VIEW_TYPE_SECTION_2 -> {
                // Create and return view holders for Section 2
                val view = LayoutInflater.from(parent.context).inflate(R.layout.cards, parent, false)
                return Section2ViewHolder(view)
            }
            VIEW_TYPE_SECTION_3 -> {
                // Create and return view holders for Section 3
                val view = LayoutInflater.from(parent.context).inflate(R.layout.cards, parent, false)
                return Section3ViewHolder(view)
            }
            else -> {
                // Handle other view types if needed
                val view = LayoutInflater.from(parent.context).inflate(R.layout.cards, parent, false)
                return Section1ViewHolder(view)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is Section1ViewHolder -> {
                // Bind data from section1Data
                val item = section1Data[position]
                holder.bind(item)
                // Bind data to your Section1ViewHolder
            }
            is Section2ViewHolder -> {
                // Bind data from section2Data
                val item = section2Data[position]
                // Bind data to your Section2ViewHolder
                holder.bind(item)
            }
            is Section3ViewHolder -> {
                // Bind data from section3Data
                val item = section3Data[position]
                // Bind data to your Section3ViewHolder
                holder.bind(item)
            }
            else -> {
                // Handle other view holders if needed
            }
        }
    }

    override fun getItemCount(): Int {
        return when (currentSection) {
            1 -> section1Data.size
            2 -> section2Data.size
            3 -> section3Data.size
            else -> 0
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (currentSection) {
            1 -> VIEW_TYPE_SECTION_1
            2 -> VIEW_TYPE_SECTION_2
            3 -> VIEW_TYPE_SECTION_3
            else -> 0
        }
    }

    // Implement methods to switch between different sections
    fun switchToSection(section: Int) {
        currentSection = section
        notifyDataSetChanged()
    }
    fun setSection1Data(data: MutableList<Section1Data>) {
        section1Data.clear()
        section1Data.addAll(data)
        notifyDataSetChanged()
    }
    fun setSection2Data(data: MutableList<Section2Data>) {
        section2Data.clear()
        section2Data.addAll(data)
        notifyDataSetChanged()
    }
    fun setSection3Data(data: MutableList<Section3Data>) {
        section3Data.clear()
        section3Data.addAll(data)
        notifyDataSetChanged()
    }




}

class Section1ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    // Define the views within your Section1ViewHolder and set them up here

    val title: TextView = itemView.findViewById(R.id.nameTextView)
    val category : TextView = itemView.findViewById(R.id.categoryTextView);
    val Location : TextView = itemView.findViewById(R.id.locationTextView);
    val distance : TextView = itemView.findViewById(R.id.distanceTextView);

    val description: TextView = itemView.findViewById(R.id.descriptionTextView)



    fun bind(data: Section1Data) {
        title.text = data.title
        description.text = data.description
        category.text = data.category
        Location.text = data.Location
        distance.text = data.distance

    }
}

class Section2ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    // Define the views within your Section2ViewHolder and set them up here
    val title: TextView = itemView.findViewById(R.id.nameTextView)
    val category : TextView = itemView.findViewById(R.id.categoryTextView);
    val Location : TextView = itemView.findViewById(R.id.locationTextView);
    val distance : TextView = itemView.findViewById(R.id.distanceTextView);

    val description: TextView = itemView.findViewById(R.id.descriptionTextView)




    fun bind(data: Section2Data) {
        title.text = data.title
        description.text = data.description
        category.text = data.category
        Location.text = data.Location
        distance.text = data.distance

    }
}

class Section3ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    // Define the views within your Section3ViewHolder and set them up here
    val title: TextView = itemView.findViewById(R.id.nameTextView)
    val category : TextView = itemView.findViewById(R.id.categoryTextView);
    val Location : TextView = itemView.findViewById(R.id.locationTextView);
    val distance : TextView = itemView.findViewById(R.id.distanceTextView);

    val description: TextView = itemView.findViewById(R.id.descriptionTextView)




    fun bind(data: Section3Data) {
        title.text = data.title
        description.text = data.description
        category.text = data.category
        Location.text = data.Location
        distance.text = data.distance

    }
}



