package com.example.afinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.afinal.databinding.ActivityUpdateBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Update : AppCompatActivity() {

    private lateinit var binding: ActivityUpdateBinding
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.updateBtn.setOnClickListener {

            val name = binding.userNameUpdate.text.toString()
            val userID = binding.userIDUpdate.text.toString()
            val age = binding.age.text.toString()
            val num = binding.contact.text.toString()

            updateData(userID, name,  age, num)
        }

    }

    private fun updateData(userID: String, name: String, age: String,num:String) {
        database = FirebaseDatabase.getInstance().getReference("Users")
        val user = mapOf<String, String>(
            "userID" to userID,
            "name" to name,
            "age" to age,
            "num" to num

        )
        database.child(userID).updateChildren(user).addOnSuccessListener {

            binding.userIDUpdate.text.clear()
            binding.userNameUpdate.text.clear()
            binding.age.text.clear()
            binding.contact.text.clear()

            Toast.makeText(this, "Successfully Update Data", Toast.LENGTH_SHORT).show()
        }.addOnFailureListener{

            Toast.makeText(this, "Failure to Update Data", Toast.LENGTH_SHORT).show()
        }
    }
}