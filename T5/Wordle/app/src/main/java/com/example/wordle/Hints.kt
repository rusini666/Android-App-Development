package com.example.wordle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Hints : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hints)

        val tv = findViewById<TextView>(R.id.tv)

        val included = MainActivity.included

        val pattern = intent.getStringExtra("pattern")

        // create the regular expression
        val regExpression = Regex(pattern!!)

        // check all words for a match with the regular expression
        var col = 0
        for (w in MainActivity.allWords) {
            if (regExpression.matches(w) && w.toList().containsAll(included.toList())) {
                tv.append(w + "  ")
                ++col
                // display 6 words to each other
                if (col % 6 == 0)
                    tv.append("\n")
            }
        }
    }
}