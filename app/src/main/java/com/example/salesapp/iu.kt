@file:Suppress("DEPRECATION")

package com.example.salesapp

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase

class iu : AppCompatActivity() {
    private lateinit var name:EditText
    private lateinit var cloth:EditText
    private lateinit var type:EditText
    private lateinit var size:EditText
    private lateinit var submit:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_iu)
        name=findViewById(R.id.m_edtname)
        cloth=findViewById(R.id.m_edtcloth)
        type=findViewById(R.id.m_edttype)
        size=findViewById(R.id.m_edtsize)
        submit=findViewById(R.id.button)

        submit.setOnClickListener {
        val name = name.text.toString().trim()
        var cloth = cloth.text.toString().trim()
        var type = type.text.toString().trim()
        var size = size.text.toString().trim()

        var time_id = System.currentTimeMillis().toString()


        var progress = ProgressDialog(this)
        progress.setTitle("Saving Data")
        progress.setMessage("Please Wait")


        if (name.isEmpty()|| cloth.isEmpty()|| type.isEmpty()|| size.isEmpty()){

            Toast.makeText(this, "cannot submit an empty field", Toast.LENGTH_SHORT).show()
        }else {
            var my_child = FirebaseDatabase.getInstance().reference.child("Names/" + time_id)
            var user_data = Productss("name", "cloth" , "type", "size")

            progress.show()
            my_child.setValue(user_data).addOnCompleteListener {
                if (it.isSuccessful){
                    Toast.makeText(this, "data uloaded", Toast.LENGTH_SHORT).show()
                    var gotoview = Intent(this, view_products::class.java)
                    startActivity(gotoview)

                }else{
                    Toast.makeText(this, "data upload failed", Toast.LENGTH_SHORT).show()
                }
            }

        }
    }


}
}