package com.example.memorygame

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button

class FiveByFour : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_five_by_four)

        val b54 = findViewById<Button>(R.id.b54)
        val b55 = findViewById<Button>(R.id.b55)
        val b56 = findViewById<Button>(R.id.b56)
        val b57 = findViewById<Button>(R.id.b57)
        val b58 = findViewById<Button>(R.id.b58)
        val b59 = findViewById<Button>(R.id.b59)
        val b60 = findViewById<Button>(R.id.b60)
        val b61 = findViewById<Button>(R.id.b61)
        val b62 = findViewById<Button>(R.id.b62)
        val b63 = findViewById<Button>(R.id.b63)
        val b64 = findViewById<Button>(R.id.b64)
        val b65 = findViewById<Button>(R.id.b65)
        val b66 = findViewById<Button>(R.id.b66)
        val b67 = findViewById<Button>(R.id.b67)
        val b68 = findViewById<Button>(R.id.b68)
        val b69 = findViewById<Button>(R.id.b69)
        val b70 = findViewById<Button>(R.id.b70)
        val b71 = findViewById<Button>(R.id.b71)
        val b72 = findViewById<Button>(R.id.b72)
        val b73 = findViewById<Button>(R.id.b73)

        val btn = arrayOf(b54,b55,b56,b57,b58,b59,b60,b61,b62,b63,b64,b65,b66,b67,b68,b69,
        b70,b71,b72,b73)
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