package com.example.afinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.afinal.databinding.ActivityMainBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var userBase : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener{

            val name = binding.Name.text.toString()
            val userID = binding.UserID.text.toString()
            val age = binding.Age.text.toString()
            val address = binding.Contact.text.toString()


            userBase = FirebaseDatabase.getInstance().getReference("Users")
            val User = Users(name, userID, age,address)
            userBase.child(userID).setValue(User).addOnSuccessListener {
                binding.Name.text.clear()
                binding.UserID.text.clear()
                binding.Age.text.clear()
                binding.Contact.text.clear()

                Toast.makeText(this,"Successfully Saved", Toast.LENGTH_SHORT).show()
            }.addOnFailureListener{

                Toast.makeText(this,"Failed", Toast.LENGTH_SHORT).show()
            }
        }
    }
}