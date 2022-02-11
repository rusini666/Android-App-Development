package com.example.lotteryprogram_v2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn: Button = findViewById(R.id.btn)
        val num1: TextView = findViewById(R.id.num1)
        val num2: TextView = findViewById(R.id.num2)
        val num3: TextView = findViewById(R.id.num3)
        val num4: TextView = findViewById(R.id.num4)
        val num5: TextView = findViewById(R.id.num5)
        val num6: TextView = findViewById(R.id.num6)

        val list = ArrayList<Int?>()
        for (i in 1..49) {
            list.add(i)
        }
        list.shuffle()
        val lotteryNum = ArrayList<Int?>()
        for (i in 0..5) {
            lotteryNum.add(list[i])
        }

        btn.setOnClickListener{
            num1.text = lotteryNum[0].toString()
            num2.text = lotteryNum[1].toString()
            num3.text = lotteryNum[2].toString()
            num4.text = lotteryNum[3].toString()
            num5.text = lotteryNum[4].toString()
            num6.text = lotteryNum[5].toString()
        }
    }
}