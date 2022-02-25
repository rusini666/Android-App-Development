package com.example.dogbreeds

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat


class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dog1 = findViewById<ImageButton>(R.id.dog1)
        val dog2 = findViewById<ImageButton>(R.id.dog2)
        val dog3 = findViewById<ImageButton>(R.id.dog3)
        val breedName = findViewById<TextView>(R.id.breedName)
        val random = (1..3).random().toString()
        val result = findViewById<TextView>(R.id.result)
        val nextBtn = findViewById<Button>(R.id.nextBtn)
        val finishBtn = findViewById<Button>(R.id.finishBtn)
        var correctScore = 0
        var wrongScore = 0

            val images = arrayOf("papillon", "toy_terrier", "vizsla", "standard_poodle", "whippet")

            images.shuffle()
            val img1 = images[0].plus("__$random")
            val img2 = images[1].plus("__$random")
            val img3 = images[2].plus("__$random")

            val breed = arrayOf(
                img1.substringBefore("__"),
                img2.substringBefore("__"),
                img3.substringBefore("__")
            )
            val actualResult = breed[(0..2).random()]
            breedName.text = actualResult


            val resource_id_1 = resources.getIdentifier(
                img1,
                "drawable",
                "com.example.dogbreeds"
            )
            val resource_id_2 = resources.getIdentifier(
                img2,
                "drawable",
                "com.example.dogbreeds"
            )
            val resource_id_3 = resources.getIdentifier(
                img3,
                "drawable",
                "com.example.dogbreeds"
            )

            dog1.setImageResource(resource_id_1)
            dog2.setImageResource(resource_id_2)
            dog3.setImageResource(resource_id_3)



            dog1.setOnClickListener {
                if (breed[0] != actualResult && result.text == "") {
                    result.text = "WRONG!"
                    result.setTextColor(ContextCompat.getColor(this, R.color.red))
                    wrongScore++
                } else if (breed[0] == actualResult && result.text == "") {
                    result.text = "CORRECT!"
                    result.setTextColor(ContextCompat.getColor(this, R.color.green))
                    correctScore++
                }
            }

            dog2.setOnClickListener {
                if (breed[1] != actualResult && result.text == "") {
                    result.text = "WRONG!"
                    result.setTextColor(ContextCompat.getColor(this, R.color.red))
                    wrongScore++
                } else if (breed[1] == actualResult && result.text == "") {
                    result.text = "CORRECT!"
                    result.setTextColor(ContextCompat.getColor(this, R.color.green))
                    correctScore++
                }
            }

            dog3.setOnClickListener {
                if (breed[2] != actualResult && result.text == "") {
                    result.text = "WRONG!"
                    result.setTextColor(ContextCompat.getColor(this, R.color.red))
                    wrongScore++
                } else if (breed[2] == actualResult && result.text == "") {
                    result.text = "CORRECT!"
                    result.setTextColor(ContextCompat.getColor(this, R.color.green))
                    correctScore++
                }
            }


        nextBtn.setOnClickListener{
            images.shuffle()
            val img1 = images[0].plus("__$random")
            val img2 = images[1].plus("__$random")
            val img3 = images[2].plus("__$random")

            val breed = arrayOf(
                img1.substringBefore("__"),
                img2.substringBefore("__"),
                img3.substringBefore("__")
            )
            val actualResult = breed[(0..2).random()]
            breedName.text = actualResult


            val resource_id_1 = resources.getIdentifier(
                img1,
                "drawable",
                "com.example.dogbreeds"
            )
            val resource_id_2 = resources.getIdentifier(
                img2,
                "drawable",
                "com.example.dogbreeds"
            )
            val resource_id_3 = resources.getIdentifier(
                img3,
                "drawable",
                "com.example.dogbreeds"
            )

            dog1.setImageResource(resource_id_1)
            dog2.setImageResource(resource_id_2)
            dog3.setImageResource(resource_id_3)
            result.text=""
        }

        finishBtn.setOnClickListener{
            val finalResults = Intent(this, FinalResults::class.java)
            finalResults.putExtra("correct", correctScore.toString())
            finalResults.putExtra("wrong", wrongScore.toString())
            startActivity(finalResults)
        }

    }
}


