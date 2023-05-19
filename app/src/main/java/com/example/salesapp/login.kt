package com.example.salesapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuth.*

class login : AppCompatActivity() {
    private lateinit var login:Button
    private lateinit var email:EditText
    private lateinit var password:EditText
    private lateinit var auth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        login =findViewById(R.id.btnlogin)
        email=findViewById(R.id.emaillogin)
        password=findViewById(R.id.passwordlogin)
       // db = openOrCreateDatabase("salesapp", MODE_PRIVATE,null)
        auth= FirebaseAuth.getInstance()
        login.setOnClickListener {
                var email = email.text.toString().trim()
                var password = password.text.toString().trim()

                //validate input
                if (email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(this, "One of the inputs is empty!", Toast.LENGTH_SHORT).show()
                } else {
                    auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this) {
                        if (it.isSuccessful) {
                            Toast.makeText(this, "Sign In Successful", Toast.LENGTH_SHORT).show()

                            var gotodashboard = Intent(this, dashboard::class.java)
                            startActivity(gotodashboard)
                            finish()
                        } else {
                            Toast.makeText(this, "Sign In Failed", Toast.LENGTH_SHORT).show()
                        }
                    }


                }
            }}}