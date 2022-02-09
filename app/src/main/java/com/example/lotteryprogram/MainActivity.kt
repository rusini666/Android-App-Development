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

        var num1 = findViewById<TextView>(R.id.num1)
        var num2 = findViewById<TextView>(R.id.num2)
        var num3 = findViewById<TextView>(R.id.num3)
        var num4 = findViewById<TextView>(R.id.num4)
        var num5 = findViewById<TextView>(R.id.num5)
        var num6 = findViewById<TextView>(R.id.num6)
        var userInput = findViewById<EditText>(R.id.userInput)
        var btn = findViewById<Button>(R.id.btn)
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
        val lists: MutableList<Int> = ArrayList()

        btn.setOnClickListener {
            val value = userInput.text.toString()

            for (i in 0..5) {
                if(value != list[i].toString())
                    lists.add(list[i])
            }

            num1.text = lists[0].toString()
            num2.text = lists[1].toString()
            num3.text = lists[2].toString()
            num4.text = lists[3].toString()
            num5.text = lists[4].toString()
            num6.text = lists[5].toString()
        }

        btn1.setOnClickListener {
            list.shuffle()
            for (i in list){
                if (num1.text != list[i].toString() )
                    num1.text = list[i].toString()
                    break
            }
        }

        btn2.setOnClickListener {
            list.shuffle()
            for (i in list){
                if (num2.text != list[i].toString() )
                    num2.text = list[i].toString()
                    break
            }
        }

        btn3.setOnClickListener {
            list.shuffle()
            for (i in list){
                if (num3.text != list[i].toString() )
                    num3.text = list[i].toString()
                    break
            }
        }

        btn4.setOnClickListener {
            list.shuffle()
            for (i in list){
                if (num4.text != list[i].toString() )
                    num4.text = list[i].toString()
                    break
            }
        }
        btn5.setOnClickListener {
            list.shuffle()
            for (i in list){
                if (num5.text != list[i].toString() )
                    num5.text = list[i].toString()
                    break
            }
        }
        btn6.setOnClickListener {
            list.shuffle()
            for (i in list){
                if (num6.text != list[i].toString() )
                    num6.text = list[i].toString()
                    break
            }
        }
    }
}

