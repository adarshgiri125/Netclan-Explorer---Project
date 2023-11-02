package com.company.assignment
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.company.assignment.RecyclerView.YourCustomAdapter

class NewActivity : AppCompatActivity() {

    private lateinit var recyclerView1: RecyclerView
    private lateinit var recyclerView2: RecyclerView
    private lateinit var recyclerView3: RecyclerView
    private lateinit var adapter1: YourCustomAdapter
    private lateinit var adapter2: YourCustomAdapter
    private lateinit var adapter3: YourCustomAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new)

        recyclerView1 = findViewById(R.id.recyclerView4)
        recyclerView2 = findViewById(R.id.recyclerView2)
        recyclerView3 = findViewById(R.id.recyclerView3)

        adapter1 = YourCustomAdapter()
        adapter2 = YourCustomAdapter()
        adapter3 = YourCustomAdapter()

        recyclerView1.adapter = adapter1
        recyclerView2.adapter = adapter2
        recyclerView3.adapter = adapter3


        // Create a list of Section1Data with the data you want to display in Section 1
        val section1DataList = mutableListOf<Section1Data>()
        section1DataList.add(Section1Data("Adarsh Giri", "Hello I live in Bhopal Madhya Pradesh. I am Doing Bachelor's Of Technology from LNCT College", "Bhopal", "Student", "Within 500m-600m"))
        section1DataList.add(Section1Data("Akash Goswami", "Hi Community! I am Open to new Connections 😊", "Bhopal", "Student Managemnet", "Within 700m-900m"))
        section1DataList.add(Section1Data("Amit Singh", "Hello I live in Bhopal Madhya Pradesh.", "Bhopal", "Student", "Within 200m"))
        val section2DataList = mutableListOf<Section2Data>()
        section2DataList.add(Section2Data("Aryan Raj", "Hi Community! I am Open to new Connections 😊", "Delhi", "Student", "Nearest"))
        section2DataList.add(Section2Data("Abhishek Gupta", "Hi Community!", "Gwalior", "Professional", "Nearest"))

        val section3DataList = mutableListOf<Section3Data>()
        section3DataList.add(Section3Data("Vijay Prajapati", "Hi Community! I am Open to new Connections \uD83D\uDE0A", "Bihar", "Student", "2.5km"))
        section3DataList.add(Section3Data("Aryan Raj", "Hi Community! I am Open to new Connections 😊", "Delhi", "Student", "Nearest"))
        section3DataList.add(Section3Data("Amit Singh", "Hello I live in Bhopal Madhya Pradesh.", "Bhopal", "Student", "Within 200m"))

       // Set the data for Section 1 in adapter1
        adapter1.setSection1Data(section1DataList)
        adapter2.setSection2Data(section2DataList)
        adapter3.setSection3Data(section3DataList)


        recyclerView1 = findViewById(R.id.recyclerView4)
        recyclerView2 = findViewById(R.id.recyclerView2)
        recyclerView3 = findViewById(R.id.recyclerView3)



            // Find the buttons by their IDs
            val buttonSection1 = findViewById<Button>(R.id.buttonSection1)
            val buttonSection2 = findViewById<Button>(R.id.buttonSection2)
            val buttonSection3 = findViewById<Button>(R.id.buttonSection3)

            // Set click listeners for the buttons
            buttonSection1.setOnClickListener {
                adapter1.switchToSection(1) // Switch to Section 1
                recyclerView1.visibility = View.VISIBLE
                recyclerView2.visibility = View.GONE
                recyclerView3.visibility = View.GONE
            }

            buttonSection2.setOnClickListener {
                adapter2.switchToSection(2) // Switch to Section 2
                recyclerView1.visibility = View.GONE
                recyclerView2.visibility = View.VISIBLE
                recyclerView3.visibility = View.GONE
            }

            buttonSection3.setOnClickListener {
                adapter3.switchToSection(3) // Switch to Section 3
                recyclerView1.visibility = View.GONE
                recyclerView2.visibility = View.GONE
                recyclerView3.visibility = View.VISIBLE
            }



        recyclerView1.layoutManager = LinearLayoutManager(this)
        recyclerView2.layoutManager = LinearLayoutManager(this)
        recyclerView3.layoutManager = LinearLayoutManager(this)


    }
}



