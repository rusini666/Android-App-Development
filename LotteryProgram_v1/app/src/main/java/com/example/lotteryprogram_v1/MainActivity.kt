package com.example.lotteryprogram_v1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var textView: TextView = findViewById(R.id.textView);
        var button: Button = findViewById(R.id.button);

        val list = ArrayList<Int?>()
        for (i in 1..49) {
            list.add(i)
        }
        list.shuffle()
        val lotteryNum = ArrayList<Int?>()
        for (i in 0..5) {
            lotteryNum.add(list[i])
        }

        button.setOnClickListener {
            val tv = lotteryNum[0].toString() + "   " + lotteryNum[1].toString() + "   " + lotteryNum[2].toString() + "   " +lotteryNum[3].toString() + "   " +
                    lotteryNum[4].toString() + "   " + lotteryNum[5].toString()
            textView.text = tv
        }
    }

}