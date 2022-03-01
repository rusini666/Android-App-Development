package com.example.memorygame

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button

class FourByFive : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_four_by_five)

        val b34 = findViewById<Button>(R.id.b34)
        val b35 = findViewById<Button>(R.id.b35)
        val b36 = findViewById<Button>(R.id.b36)
        val b37 = findViewById<Button>(R.id.b37)
        val b38 = findViewById<Button>(R.id.b38)
        val b39 = findViewById<Button>(R.id.b39)
        val b40 = findViewById<Button>(R.id.b40)
        val b41 = findViewById<Button>(R.id.b41)
        val b42 = findViewById<Button>(R.id.b42)
        val b43 = findViewById<Button>(R.id.b43)
        val b44 = findViewById<Button>(R.id.b44)
        val b45 = findViewById<Button>(R.id.b45)
        val b46 = findViewById<Button>(R.id.b46)
        val b47 = findViewById<Button>(R.id.b47)
        val b48 = findViewById<Button>(R.id.b48)
        val b49 = findViewById<Button>(R.id.b49)
        val b50 = findViewById<Button>(R.id.b50)
        val b51 = findViewById<Button>(R.id.b51)
        val b52 = findViewById<Button>(R.id.b52)
        val b53 = findViewById<Button>(R.id.b53)

        val btn = arrayOf(b34,b35,b36,b37,b38,b39,b40,b41,b42,b43,b44,b45,b46,b47,b48,b49,
            b50,b51,b52,b53)
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

    }
}