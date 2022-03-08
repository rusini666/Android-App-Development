package com.example.memorygame

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView

class FourByThree : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_four_by_three)

        val b22 = findViewById<Button>(R.id.b22)
        val b23 = findViewById<Button>(R.id.b23)
        val b24 = findViewById<Button>(R.id.b24)
        val b25 = findViewById<Button>(R.id.b25)
        val b26 = findViewById<Button>(R.id.b26)
        val b27 = findViewById<Button>(R.id.b27)
        val b28 = findViewById<Button>(R.id.b28)
        val b29 = findViewById<Button>(R.id.b29)
        val b30 = findViewById<Button>(R.id.b30)
        val b31 = findViewById<Button>(R.id.b31)
        val b32 = findViewById<Button>(R.id.b32)
        val b33 = findViewById<Button>(R.id.b33)

        val scoreDisplay3 = findViewById<TextView>(R.id.scoreDisplay3)
        val restart = Intent(this, MainActivity::class.java)
        val btn = arrayOf(b22,b23,b24,b25,b26,b27,b28,b29,b30,b31,b32,b33)

        val randomBtn = ArrayList<Button>()
        val randomNum = (4..6).random()
        btn.shuffle()
        var userClicks = 0
        var tries = 0

        val prefs = getSharedPreferences("com.example.memorygame",MODE_PRIVATE)

        for(i in 1..randomNum)
            randomBtn.add(btn[i])

        object : CountDownTimer(5000, 50) {
            override fun onTick(arg0: Long) {
                for (i in randomBtn)
                    i.setBackgroundColor(Color.GREEN)
            }

            override fun onFinish() {

                for (i in randomBtn)
                    i.setBackgroundColor(Color.parseColor("#6200EE")) // back to default color of the buttons
                for (j in btn) {
                    j.setOnClickListener {

                        if(tries != randomNum){
                            if (j in randomBtn) {
                                ++userClicks
                                ++tries
                                object : CountDownTimer(2000, 50) {
                                    override fun onTick(arg0: Long) {
                                        j.setBackgroundColor(Color.GREEN)
                                    }

                                    override fun onFinish() {
                                        j.setBackgroundColor(Color.parseColor("#6200EE"))
                                    }
                                }.start()
                            } else {
                                ++tries
                                object : CountDownTimer(2000, 50) {
                                    override fun onTick(arg0: Long) {
                                        j.setBackgroundColor(Color.RED)
                                        j.text = "X"
                                    }

                                    override fun onFinish() {
                                        j.setBackgroundColor(Color.parseColor("#6200EE"))
                                        j.text = ""
                                    }
                                }.start()
                            }
                            val value = userClicks.toString()
                            val userTries = tries.toString()
                            scoreDisplay3.text = "Score: $value / $userTries"
                        }else{
                            startActivity(restart)
                        }

                    }
                }

            }
        }.start()
    }
}