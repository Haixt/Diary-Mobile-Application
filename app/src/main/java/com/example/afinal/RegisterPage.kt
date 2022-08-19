package com.example.afinal

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_register.*

class RegisterPage  : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var emailEt : TextInputEditText
    private lateinit var passwordEt : TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        auth = Firebase.auth
        emailEt = findViewById(R.id.email_input)
        passwordEt = findViewById(R.id.password_input)


        btnRegister.setOnClickListener{
            var email: String = emailEt.text.toString()
            var password: String = passwordEt.text.toString()

            if(TextUtils.isEmpty(email) || TextUtils.isEmpty(password) ){
                Toast.makeText(this,"Please Fill All The Fields",Toast.LENGTH_LONG).show()
            }else{
                auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this,
                    OnCompleteListener { task ->
                        if(task.isSuccessful){
                            Toast.makeText(this,"User Created",Toast.LENGTH_LONG).show()
                            val intent = Intent(this,Login::class.java)
                            startActivity(intent)
                        }else{
                            Toast.makeText(this,"User Creation Failed", Toast.LENGTH_LONG).show()
                        }
                    })
            }
        }


    }
}