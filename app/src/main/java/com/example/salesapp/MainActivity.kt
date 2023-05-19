package com.example.salesapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var signin:Button
    private lateinit var signup:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        signin=findViewById(R.id.btnsignin)
        signup=findViewById(R.id.btnsignup)

        signin.setOnClickListener {

            var gotologin = Intent(this,login::class.java)
            startActivity(gotologin)
        }
        signup.setOnClickListener {
            var gotosignup = Intent(this,Signup::class.java)
            startActivity(gotosignup)
        }
    }
}