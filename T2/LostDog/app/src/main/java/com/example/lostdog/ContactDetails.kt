package com.example.lostdog

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
class ContactDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_details)
//        val contact = findViewById<Button>(R.id.call_button)
//        val email = findViewById<Button>(R.id.email_button)
//        contact.setOnClickListener {
//            val phoneUri = Uri.parse("tel:02079115000")
//            val i = Intent(Intent.ACTION_DIAL, phoneUri)
//            startActivity(i)
//        }
//        email.setOnClickListener {
//            val i = Intent(Intent.ACTION_SEND)
//            i.type = "text/plain"
//            i.putExtra(Intent.EXTRA_EMAIL, arrayOf("recipient@my.westminster.ac.uk"))
//            i.putExtra(Intent.EXTRA_TEXT, "Hello, I think I found your dog")
//            i.putExtra(Intent.EXTRA_SUBJECT, "Your lost dog")
//            startActivity(i)
//        }
    }
}