package com.example.lostdog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bt = findViewById<Button>(R.id.button)
        bt.setOnClickListener {
            val contactIntent = Intent(this, ContactDetails::class.java)
            startActivity(contactIntent)
        }
    }
}