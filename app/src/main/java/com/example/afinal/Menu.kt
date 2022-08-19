package com.example.afinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val addButton = findViewById<Button>(R.id.addBtn)
        val deleteButton = findViewById<Button>(R.id.deleteBtn)
        val searchButton = findViewById<Button>(R.id.viewBtn)
        val updateButton = findViewById<Button>(R.id.updateUserBtn)

        addButton.setOnClickListener{

            val Intent = Intent(this,MainActivity::class.java)
            startActivity(Intent)
        }
        deleteButton.setOnClickListener{

            val Intent = Intent(this,Delete::class.java)
            startActivity(Intent)
        }
        searchButton.setOnClickListener{

            val Intent = Intent(this,UserProfileCard::class.java)
            startActivity(Intent)
        }
        updateButton.setOnClickListener{

            val Intent = Intent(this,Update::class.java)
            startActivity(Intent)
        }
    }
}