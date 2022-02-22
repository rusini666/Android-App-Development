package com.example.lotteryprogram

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
        val btn1 = findViewById<Button>(R.id.btn1)
        val btn2 = findViewById<Button>(R.id.btn2)
        val btn3 = findViewById<Button>(R.id.btn3)
        val btn4 = findViewById<Button>(R.id.btn4)
        val btn5 = findViewById<Button>(R.id.btn5)
        val btn6 = findViewById<Button>(R.id.btn6)

        val list = ArrayList<Int>()
        for (i in 1..48) {
            list.add(i)
        }
        list.shuffle()
        val lotteryNum: ArrayList<Int> = ArrayList()

        val value = userInput.text.toString()
        for (i in list) {
            if (value != i.toString())
                lotteryNum.add(i)
        }

        val currentLotteryNum: ArrayList<Int> = ArrayList()

        btn.setOnClickListener {
            for(i in 0..5)
                currentLotteryNum.add(lotteryNum[i])

            num1.text = currentLotteryNum[0].toString()
            num2.text = currentLotteryNum[1].toString()
            num3.text = currentLotteryNum[2].toString()
            num4.text = currentLotteryNum[3].toString()
            num5.text = currentLotteryNum[4].toString()
            num6.text = currentLotteryNum[5].toString()
        }

        btn1.setOnClickListener {
            list.shuffle()
            for (i in list) {
                if (i !in currentLotteryNum) {
                    num1.text = i.toString()
                    currentLotteryNum[0] = i
                    break
                }
            }
        }

        btn2.setOnClickListener {
            list.shuffle()
            for (i in list) {
                if (i !in currentLotteryNum) {
                    num2.text = i.toString()
                    currentLotteryNum[1] = i
                    break
                }
            }
        }

        btn3.setOnClickListener {
            list.shuffle()
            for (i in list) {
                if (i !in currentLotteryNum) {
                    num3.text = i.toString()
                    currentLotteryNum[2] = i
                    break
                }
            }
        }

        btn4.setOnClickListener {
            list.shuffle()
            for (i in list) {
                if (i !in currentLotteryNum) {
                    num4.text = i.toString()
                    currentLotteryNum[3] = i
                    break
                }
            }
        }
        btn5.setOnClickListener {
            list.shuffle()
            for (i in list) {
                if (i !in currentLotteryNum) {
                    num5.text = i.toString()
                    currentLotteryNum[4] = i
                    break
                }
            }
        }
        btn6.setOnClickListener {
            list.shuffle()
            for (i in list) {
                if (i !in currentLotteryNum) {
                    num6.text = i.toString()
                    currentLotteryNum[5] = i
                    break
                }
            }
        }
    }
}

