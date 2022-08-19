package com.example.afinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.afinal.databinding.ActivityDeleteBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Delete : AppCompatActivity() {
    private lateinit var binding: ActivityDeleteBinding
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDeleteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.deleteUserBtn.setOnClickListener{
            var userID = binding.deletedUserID.text.toString()
            if(userID.isNotEmpty())
                deleteData(userID)
            else
                Toast.makeText(this, "Please enter User ID", Toast.LENGTH_SHORT).show()
        }
    }
    private fun deleteData(userID: String) {

        database = FirebaseDatabase.getInstance().getReference("Users")
        database.child(userID).removeValue().addOnSuccessListener {

            binding.deletedUserID.text.clear()
            Toast.makeText(this, " User ID Deleted Successfully", Toast.LENGTH_SHORT).show()

        }.addOnFailureListener{
            Toast.makeText(this, "User ID Deletion Failed", Toast.LENGTH_SHORT).show()
        }
    }
}