package com.example.memorygame

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        when((1..6).random()){
            1 -> {
                val i1 = Intent(this, ThreeByThree::class.java);
                startActivity(i1);
            }
            2 ->{
                val i2 = Intent(this, ThreeByFour::class.java);
                startActivity(i2);
            }
            3 ->{
                val i3 = Intent(this, FourByThree::class.java);
                startActivity(i3);
            }
            4 -> {
                val i4 = Intent(this, FourByFive::class.java);
                startActivity(i4);
            }
            5 -> {
                val i5 = Intent(this, FiveByFour::class.java);
                startActivity(i5);
            }
            6 ->{
                val i6 = Intent(this, FiveByFive::class.java);
                startActivity(i6);
            }
        }
    }
}