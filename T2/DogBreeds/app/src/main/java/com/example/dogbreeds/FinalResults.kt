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

        var correct: String = intent.getStringExtra("correct").toString()
        var wrong: String = intent.getStringExtra("wrong").toString()

        finalCorrect.text = correct
        finalWrong.text = wrong

    }
}