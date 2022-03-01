package com.example.memorygame

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button

class ThreeByFour : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_three_by_four)

        val b10 = findViewById<Button>(R.id.b10)
        val b11 = findViewById<Button>(R.id.b11)
        val b12 = findViewById<Button>(R.id.b12)
        val b13 = findViewById<Button>(R.id.b13)
        val b14 = findViewById<Button>(R.id.b14)
        val b15 = findViewById<Button>(R.id.b15)
        val b16 = findViewById<Button>(R.id.b16)
        val b17 = findViewById<Button>(R.id.b17)
        val b18 = findViewById<Button>(R.id.b18)
        val b19 = findViewById<Button>(R.id.b19)
        val b20 = findViewById<Button>(R.id.b20)
        val b21 = findViewById<Button>(R.id.b21)

        val btn = arrayOf(b10,b11,b12,b13,b14,b15,b16,b17,b18,b19,b20,b21)
        val randomBtn = ArrayList<Button>()
        val randomNum = (4..6).random()
        btn.shuffle()

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
                if (j in randomBtn) {
                    object : CountDownTimer(2000, 50) {
                        override fun onTick(arg0: Long) {
                            j.setBackgroundColor(Color.GREEN)
                        }

                        override fun onFinish() {
                            j.setBackgroundColor(Color.parseColor("#6200EE"))
                        }
                    }.start()

                } else {
                    object : CountDownTimer(2000, 50) {
                        override fun onTick(arg0: Long) {
                            j.setBackgroundColor(Color.RED)
                            j.setText("X")
                        }

                        override fun onFinish() {
                            j.setBackgroundColor(Color.parseColor("#6200EE"))
                            j.setText("")
                        }
                    }.start()
                }
            }
        }




    }
}