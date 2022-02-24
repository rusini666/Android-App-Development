package com.example.lostdog_v2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bt = findViewById<Button>(R.id.button)

        val imageView = findViewById<ImageView>(R.id.imageView)
        val resource : String = "brittany_02625"
        val resource_id = resources.getIdentifier(resource, "drawable", "com.example.lostdog_v2" )
        imageView.setImageResource(resource_id)


        bt.setOnClickListener {
            val contactIntent = Intent(this, ContactDetails::class.java)
            startActivity(contactIntent)
        }
    }
}