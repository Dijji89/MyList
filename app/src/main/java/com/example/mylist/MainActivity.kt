package com.example.mylist

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    var persons = mutableListOf<Person>()
    lateinit var rw: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        persons.add(Person("Лёша", "Гришкевич", "+375-44-675-33-66", R.drawable.p1))
        persons.add(Person(" Антон", "Пальцев", "+375-33-678-55-66", R.drawable.p2))
        persons.add(Person("Илья", "Каменский", "+375-29-609-12-90", R.drawable.p3))
        persons.add(Person("Никита", "Иванов", "+375-44-666-33-45", R.drawable.p4))

        rw = findViewById(R.id.rw)
        val btnAdd = findViewById<Button>(R.id.button)

        rw.adapter = PersonAdapter(persons, this)
        rw.layoutManager = LinearLayoutManager(this)

        btnAdd.setOnClickListener {
            persons.add(Person("Джон", "Смит", "+375-29-536-45-78", R.drawable.p6))
            rw.adapter?.notifyItemInserted(persons.lastIndex)
        }
    }

    fun onItemClick(position:Int) {
        Toast.makeText(this,"Hello, ${persons[position].name}!", Toast.LENGTH_SHORT).show()
    }

    fun deleteItem(position: Int) {
        persons.removeAt(position)
        rw.adapter?.notifyItemRemoved(position)
    }
}