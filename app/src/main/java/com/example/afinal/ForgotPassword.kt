package com.example.afinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_forgot_password.*

class ForgotPassword : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var emailEt : TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        auth = Firebase.auth
        emailEt = findViewById(R.id.forgot_email_input)

        btnForgot.setOnClickListener{
            var email:String = emailEt.text.toString()
            if (TextUtils.isEmpty(email)){
                Toast.makeText(this,"Please enter Email Address",Toast.LENGTH_LONG).show()
            }else{
                auth.sendPasswordResetEmail(email)
                    .addOnCompleteListener (this, OnCompleteListener { task ->
                        if (task.isSuccessful){
                            Toast.makeText(this,"Reset link sent to your email",Toast.LENGTH_LONG).show()
                        }else{
                            Toast.makeText(this,"Reset link unable  to send your email",Toast.LENGTH_LONG).show()
                        }
                    })
            }
        }
        btnReturn.setOnClickListener{
            val intents = Intent(this,Login :: class.java)
            startActivity(intents)
        }
    }
}