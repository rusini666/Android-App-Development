package com.example.lotterynum_v3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val num1 = findViewById<TextView>(R.id.num1)
        val num2 = findViewById<TextView>(R.id.num2)
        val num3 = findViewById<TextView>(R.id.num3)
        val num4 = findViewById<TextView>(R.id.num4)
        val num5 = findViewById<TextView>(R.id.num5)
        val num6 = findViewById<TextView>(R.id.num6)
        val userInput = findViewById<EditText>(R.id.userInput)
        val btn = findViewById<Button>(R.id.btn)

        val list = ArrayList<Int?>()
        for (i in 1..49) {
            list.add(i)
        }
        list.shuffle()
        val lotteryNum = ArrayList<Int?>()


        btn.setOnClickListener {
            val value = userInput.text.toString()
            for (i in 0..5) {
                if(value != list[i].toString())
                    lotteryNum.add(list[i])
            }

            num1.text = lotteryNum[0].toString()
            num2.text = lotteryNum[1].toString()
            num3.text = lotteryNum[2].toString()
            num4.text = lotteryNum[3].toString()
            num5.text = lotteryNum[4].toString()
            num6.text = lotteryNum[5].toString()
        }
    }
}