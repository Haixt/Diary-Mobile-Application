package com.example.afinal

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_login.*

class Login : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        auth = Firebase.auth

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        Login_btnLogin.setOnClickListener{

            var email: String = email_input.text.toString()
            var password: String = password_input.text.toString()

            if(TextUtils.isEmpty(email)|| TextUtils.isEmpty(password)){
                Toast.makeText(this, "Please fill all the fields",Toast.LENGTH_SHORT).show()
            }else{
               auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this,
                   OnCompleteListener { task ->
                       if(task.isSuccessful){
                           Toast.makeText(this,"Successfully Logged In",Toast.LENGTH_LONG).show()
                           val intent = Intent(this,Menu::class.java)
                           startActivity(intent)
                           finish()
                       }else{
                           Toast.makeText(this,"Login Failed", Toast.LENGTH_LONG).show()
                       }
                   })
            }
        }
        Login_btnRegister.setOnClickListener{
            val intents = Intent(this,RegisterPage :: class.java)
            startActivity(intents)
        }
        Login_btnForgot.setOnClickListener{
            val intents = Intent(this,ForgotPassword :: class.java)
            startActivity(intents)
        }
    }





}