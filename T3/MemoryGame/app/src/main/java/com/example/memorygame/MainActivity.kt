package com.example.memorygame

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.TextView
import androidx.gridlayout.widget.GridLayout

class MainActivity : AppCompatActivity() {

    var userClicks = 0
    var totalTries = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val gridLayout1 = findViewById<GridLayout>(R.id.gridLayout1)
        val b1 = findViewById<Button>(R.id.b1)
        val b2 = findViewById<Button>(R.id.b2)
        val b3 = findViewById<Button>(R.id.b3)
        val b4 = findViewById<Button>(R.id.b4)
        val b5 = findViewById<Button>(R.id.b5)
        val b6 = findViewById<Button>(R.id.b6)
        val b7 = findViewById<Button>(R.id.b7)
        val b8 = findViewById<Button>(R.id.b8)
        val b9 = findViewById<Button>(R.id.b9)

        val gridLayout2 = findViewById<GridLayout>(R.id.gridLayout2)
        val b10 = findViewById<Button>(R.id.b10)
        val b11 = findViewById<Button>(R.id.b11)
        val b12 = findViewById<Button>(R.id.b12)
        val b13 = findViewById<Button>(R.id.b13)
        val b14 = findViewById<Button>(R.id.b14)
        val b15 = findViewById<Button>(R.id.b15)
        val b16 = findViewById<Button>(R.id.b16)
        val b17 = findViewById<Button>(R.id.b17)
        val b18 = findViewById<Button>(R.id.b18)
        val b19 = findViewById<Button>(R.id.b19)
        val b20 = findViewById<Button>(R.id.b20)
        val b21 = findViewById<Button>(R.id.b21)

        val gridLayout3 = findViewById<GridLayout>(R.id.gridLayout3)
        val b22 = findViewById<Button>(R.id.b22)
        val b23 = findViewById<Button>(R.id.b23)
        val b24 = findViewById<Button>(R.id.b24)
        val b25 = findViewById<Button>(R.id.b25)
        val b26 = findViewById<Button>(R.id.b26)
        val b27 = findViewById<Button>(R.id.b27)
        val b28 = findViewById<Button>(R.id.b28)
        val b29 = findViewById<Button>(R.id.b29)
        val b30 = findViewById<Button>(R.id.b30)
        val b31 = findViewById<Button>(R.id.b31)
        val b32 = findViewById<Button>(R.id.b32)
        val b33 = findViewById<Button>(R.id.b33)

        val gridLayout4 = findViewById<GridLayout>(R.id.gridLayout4)
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

        val gridLayout5 = findViewById<GridLayout>(R.id.gridLayout5)
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


        val gridLayout6 = findViewById<GridLayout>(R.id.gridLayout6)
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

        val scoreDisplay = findViewById<TextView>(R.id.scoreDisplay)

        //val grids = arrayOf(gridLayout1, gridLayout2, gridLayout3, gridLayout4, gridLayout5, gridLayout6)


        fun restart(){

            when ((1..6).random()) {
                1 -> {
                    var tries = 0
                    gridLayout1.visibility = VISIBLE
                    val btn = arrayOf(b1, b2, b3, b4, b5, b6, b7, b8, b9)
                    btn.shuffle()
                    val randomBtn = ArrayList<Button>()
                    val randomNum = (4..6).random()
                    for (i in 1..randomNum)
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

                                    if (tries != randomNum) {
                                        if (j in randomBtn) {
                                            ++userClicks
                                            ++tries
                                            ++totalTries
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
                                            ++totalTries
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
                                        val userTries = totalTries.toString()
                                        scoreDisplay.text = "Score: $value / $userTries"
                                    } else {
                                        gridLayout1.visibility = INVISIBLE
                                        restart()
                                    }

                                }
                            }

                        }

                    }.start()
                }
                2 -> {
                    var tries = 0
                    gridLayout2.visibility = VISIBLE
                    val btn = arrayOf(b10,b11,b12,b13,b14,b15,b16,b17,b18,b19,b20,b21)
                    btn.shuffle()
                    val randomBtn = ArrayList<Button>()
                    val randomNum = (4..6).random()
                    for (i in 1..randomNum)
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

                                    if (tries != randomNum) {
                                        if (j in randomBtn) {
                                            ++userClicks
                                            ++tries
                                            ++totalTries
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
                                            ++totalTries
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
                                        val userTries = totalTries.toString()
                                        scoreDisplay.text = "Score: $value / $userTries"
                                    } else {
                                        gridLayout2.visibility = INVISIBLE
                                        restart()
                                    }

                                }
                            }

                        }

                    }.start()
                }
                3 -> {
                    var tries = 0
                    gridLayout3.visibility = VISIBLE
                    val btn = arrayOf(b22,b23,b24,b25,b26,b27,b28,b29,b30,b31,b32,b33)
                    btn.shuffle()
                    val randomBtn = ArrayList<Button>()
                    val randomNum = (4..6).random()
                    for (i in 1..randomNum)
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

                                    if (tries != randomNum) {
                                        if (j in randomBtn) {
                                            ++userClicks
                                            ++tries
                                            ++totalTries
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
                                            ++totalTries
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
                                        val userTries = totalTries.toString()
                                        scoreDisplay.text = "Score: $value / $userTries"
                                    } else {
                                        gridLayout3.visibility = INVISIBLE
                                        restart()
                                    }

                                }
                            }

                        }

                    }.start()
                }
                4 -> {
                    var tries = 0
                    gridLayout4.visibility = VISIBLE
                    val btn = arrayOf(b34,b35,b36,b37,b38,b39,b40,b41,b42,b43,b44,b45,b46,b47,b48,b49,
                        b50,b51,b52,b53)
                    btn.shuffle()
                    val randomBtn = ArrayList<Button>()
                    val randomNum = (4..6).random()
                    for (i in 1..randomNum)
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

                                    if (tries != randomNum) {
                                        if (j in randomBtn) {
                                            ++userClicks
                                            ++tries
                                            ++totalTries
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
                                            ++totalTries
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
                                        val userTries = totalTries.toString()
                                        scoreDisplay.text = "Score: $value / $userTries"
                                    } else {
                                        gridLayout4.visibility = INVISIBLE
                                        restart()
                                    }

                                }
                            }

                        }

                    }.start()
                }
                5 -> {
                    var tries = 0
                    gridLayout5.visibility = VISIBLE
                    val btn = arrayOf(b54,b55,b56,b57,b58,b59,b60,b61,b62,b63,b64,b65,b66,b67,b68,b69,
                        b70,b71,b72,b73)
                    btn.shuffle()
                    val randomBtn = ArrayList<Button>()
                    val randomNum = (4..6).random()
                    for (i in 1..randomNum)
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

                                    if (tries != randomNum) {
                                        if (j in randomBtn) {
                                            ++userClicks
                                            ++tries
                                            ++totalTries
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
                                            ++totalTries
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
                                        val userTries = totalTries.toString()
                                        scoreDisplay.text = "Score: $value / $userTries"
                                    } else {
                                        gridLayout5.visibility = INVISIBLE
                                        restart()
                                    }

                                }
                            }

                        }

                    }.start()

                }
                6 -> {
                    var tries = 0
                    gridLayout6.visibility = VISIBLE
                    val btn = arrayOf(b74,b75,b76,b77,b78,b79,b80,b81,b82,b83,b84,b85,b86,b87,b88,b89,
                        b90,b91,b92,b93,b94,b95,b96,b97,b98)
                    btn.shuffle()
                    val randomBtn = ArrayList<Button>()
                    val randomNum = (4..6).random()
                    for (i in 1..randomNum)
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

                                    if (tries != randomNum) {
                                        if (j in randomBtn) {
                                            ++userClicks
                                            ++tries
                                            ++totalTries
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
                                            ++totalTries
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
                                        val userTries = totalTries.toString()
                                        scoreDisplay.text = "Score: $value / $userTries"
                                    } else {
                                        gridLayout6.visibility = INVISIBLE
                                        restart()
                                    }
                                }
                            }
                        }
                    }.start()
                }
            }
        }
        restart()
    }
}