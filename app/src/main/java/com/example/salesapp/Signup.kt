package com.example.salesapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class Signup : AppCompatActivity() {
    private lateinit var email:EditText
    private lateinit var username:EditText
    private lateinit var password:EditText
    private lateinit var confirmpassword:EditText
    private lateinit var submit:Button
    private lateinit var auth:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        email=findViewById(R.id.EmailAddress)
        username=findViewById(R.id.username)
        password=findViewById(R.id.enterpassword)
        confirmpassword=findViewById(R.id.confirmpasswrod)
        submit=findViewById(R.id.submit)
        auth = FirebaseAuth.getInstance()
        submit.setOnClickListener{



            var email = email.text.toString().trim()
            var username = username.text.toString().trim()
            var password = password.text.toString().trim()
            var confirmpassword = confirmpassword.text.toString().trim()

            //validate your input
            if (email.isEmpty() || username.isEmpty() || password.isEmpty()|| confirmpassword.isEmpty()){
                Toast.makeText(this, "One of the fields is empty.", Toast.LENGTH_SHORT).show()

            }
            else{
                //create a user in firebase
                auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this) {
                    if (it.isSuccessful){
                        Toast.makeText(this, "User Created Successfully", Toast.LENGTH_SHORT).show()

                        var gotologin = Intent(this, login::class.java)
                        startActivity(gotologin)

                    }
                    else{
                        Toast.makeText(this, "Failed to Create Account", Toast.LENGTH_SHORT).show()

                        Log.d("TAG", "error--->",it.exception)

                    }

    }}}}
}