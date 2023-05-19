package com.example.salesapp

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase

class dashboard : AppCompatActivity() {
    private lateinit var profile: ImageView
    private lateinit var cart: ImageView
    private lateinit var exit: ImageView
    private lateinit var pointofsale: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        profile = findViewById(R.id.profile)
        cart = findViewById(R.id.cart)
        exit = findViewById(R.id.exit)
        pointofsale = findViewById(R.id.pos)

        cart.setOnClickListener {
            var gotoiu = Intent(this, iu::class.java)
            startActivity(gotoiu)

        }
        exit.setOnClickListener {
            var gotohomepage = Intent(this, MainActivity::class.java)
            startActivity(gotohomepage)
        }
        profile.setOnClickListener {
            var gotoproductss = Intent(this,Productss::class.java)
            startActivity(gotoproductss)
        }
    }
}