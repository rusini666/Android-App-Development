package com.example.memorygame

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class ThreeByThree : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_three_by_three)

        val b1 = findViewById<Button>(R.id.b1)
        val b2 = findViewById<Button>(R.id.b2)
        val b3 = findViewById<Button>(R.id.b3)
        val b4 = findViewById<Button>(R.id.b4)
        val b5 = findViewById<Button>(R.id.b5)
        val b6 = findViewById<Button>(R.id.b6)
        val b7 = findViewById<Button>(R.id.b7)
        val b8 = findViewById<Button>(R.id.b8)
        val b9 = findViewById<Button>(R.id.b9)


        val scoreDisplay = findViewById<TextView>(R.id.scoreDisplay)

        val btn = arrayOf(b1,b2,b3,b4,b5,b6,b7,b8,b9)
        btn.shuffle()

        val randomBtn = ArrayList<Button>()
        val randomNum = (4..6).random()
        var userClicks = 0
        var tries = 0
        for(i in 1..randomNum)
            randomBtn.add(btn[i])

        object : CountDownTimer(5000, 50) {
            override fun onTick(arg0: Long) {
                for (i in randomBtn)
                    i.setBackgroundColor(Color.GREEN)
            }

            override fun onFinish() {
                for (i in randomBtn)
                    i.setBackgroundColor(Color.parseColor("#6200EE"))
            }
        }.start()


        for (j in btn) {
            j.setOnClickListener {
                if(tries != randomNum){
                    if (j in randomBtn) {
                        userClicks++
                        tries++

                        object : CountDownTimer(2000, 50) {
                            override fun onTick(arg0: Long) {
                                j.setBackgroundColor(Color.GREEN)
                                var value = userClicks.toString()
                                scoreDisplay.text = "$value / $randomNum"
                            }

                            override fun onFinish() {
                                j.setBackgroundColor(Color.parseColor("#6200EE"))
                            }
                        }.start()
                    } else {
                        tries++
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
                }else{
                    val restart = Intent(this, MainActivity::class.java)
                    startActivity(restart)
                }

            }
        }
    }
}


