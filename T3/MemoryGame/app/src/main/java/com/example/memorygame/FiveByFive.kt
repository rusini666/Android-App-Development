package com.example.memorygame

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView

class FiveByFive : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_five_by_five)

        val b74 = findViewById<Button>(R.id.b74)
        val b75 = findViewById<Button>(R.id.b75)
        val b76 = findViewById<Button>(R.id.b76)
        val b77 = findViewById<Button>(R.id.b77)
        val b78 = findViewById<Button>(R.id.b78)
        val b79 = findViewById<Button>(R.id.b79)
        val b80 = findViewById<Button>(R.id.b80)
        val b81 = findViewById<Button>(R.id.b81)
        val b82 = findViewById<Button>(R.id.b82)
        val b83 = findViewById<Button>(R.id.b83)
        val b84 = findViewById<Button>(R.id.b84)
        val b85 = findViewById<Button>(R.id.b85)
        val b86 = findViewById<Button>(R.id.b86)
        val b87 = findViewById<Button>(R.id.b87)
        val b88 = findViewById<Button>(R.id.b88)
        val b89 = findViewById<Button>(R.id.b89)
        val b90 = findViewById<Button>(R.id.b90)
        val b91 = findViewById<Button>(R.id.b91)
        val b92 = findViewById<Button>(R.id.b92)
        val b93 = findViewById<Button>(R.id.b93)
        val b94 = findViewById<Button>(R.id.b94)
        val b95 = findViewById<Button>(R.id.b95)
        val b96 = findViewById<Button>(R.id.b96)
        val b97 = findViewById<Button>(R.id.b97)
        val b98 = findViewById<Button>(R.id.b98)

        val scoreDisplay6 = findViewById<TextView>(R.id.scoreDisplay6)

        val btn = arrayOf(b74,b75,b76,b77,b78,b79,b80,b81,b82,b83,b84,b85,b86,b87,b88,b89,
            b90,b91,b92,b93,b94,b95,b96,b97,b98)
        btn.shuffle()

        val randomBtn = ArrayList<Button>()
        val randomNum = (4..6).random()

        var userClicks = 0
        var tries = 0

        val prefs = getSharedPreferences("com.example.memorygame",MODE_PRIVATE)

        val restart = Intent(this, MainActivity::class.java)
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
                            scoreDisplay6.text = "Score: $value / $userTries"
                        }else{
                            startActivity(restart)
                        }

                    }
                }

            }
        }.start()
    }
}