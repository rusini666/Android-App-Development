package com.example.dogbreeds

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class FinalResults : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final_results)

        val finalCorrect = findViewById<TextView>(R.id.finalCorrect)
        val finalWrong = findViewById<TextView>(R.id.finalWrong)

        val correctR = intent.getStringExtra("correct").toString()
        val wrongR = intent.getStringExtra("wrong").toString()

        finalCorrect.text = correctR
        finalWrong.text = wrongR

    }
}