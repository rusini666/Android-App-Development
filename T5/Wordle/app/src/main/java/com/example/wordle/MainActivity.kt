package com.example.wordle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.room.Room
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    val wordSize = 5
    val number_of_attempts = 6

    companion object {
        var allWords: MutableList<String> = mutableListOf()
        // the chars which are definitely in the secret word because of a previous guess
        var included = mutableSetOf<Char>()
    }
    lateinit var wordDao: WordDao
    var letters: MutableList<MutableList<Button>> = mutableListOf()

    lateinit var delButton: Button
    lateinit var enterButton: Button
    lateinit var hintsButton: Button

    // the row and the column that the player is placing a character next
    var current_row = 0
    var current_col = 0
    lateinit var secret_word: String

    // map of resource-ids to characters for the keyboard
    var keyMap: MutableMap<Button, String> = mutableMapOf()

    var alphabet = mutableSetOf('a','b','c','d','e','f','g','h','i','j','k', 'l','m',
        'n','o','p','q','r','s','t','u','v','w','x','y')

    // candidate characters for each of the 5 positions of the word
    var candidates = mutableListOf<MutableSet<Char>>(alphabet.toMutableSet(), alphabet.toMutableSet(),
        alphabet.toMutableSet(), alphabet.toMutableSet(), alphabet.toMutableSet())

    // the chars which are definitely not in the word because of a previous guess
    var excluded = mutableSetOf<Char>()

    // textView displaying the correct answer once all attempts are exhausted
    lateinit var correct: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initialise_widgets()

        // create an instance of the database
        val db = Room.databaseBuilder(this, AppDatabase::class.java, "words-database").build()
        wordDao= db.wordDao()

        retrieveWordsFromDatabase()

        // choose a random secret word
        val generator = Random
        val random_index = generator.nextInt(allWords.size)
        secret_word = allWords[random_index]
        Log.d("***** Secret word: ", allWords[random_index])

    }


    /* get the words from the database - if not there populate the BD
       from the file */
    fun retrieveWordsFromDatabase() {
        runBlocking {
            val num_of_words = wordDao.countAll()
            Log.d("******* num of words: ", "$num_of_words")
            if (num_of_words < 10) {
                readFromFile()
                // add all the words to the database
                launch {
                    // first delete all data before adding new one
                    wordDao.deleteAll()

                    for (i in 0..allWords.size-1)
                        wordDao.insertAll(Word(i, allWords[i]))
                }
            }
            else {  // load from the DB
                val list = wordDao.getAll()
                // load the list of strings
                for (w in list)
                    allWords.add(w.entry)
            }
        }
    }


    fun initialise_widgets() {
        val letter_buttons_ids = listOf(listOf(R.id.r00, R.id.r01, R.id.r02, R.id.r03, R.id.r04),
            listOf(R.id.r10, R.id.r11, R.id.r12, R.id.r13, R.id.r14),
            listOf(R.id.r20, R.id.r21, R.id.r22, R.id.r23, R.id.r24),
            listOf(R.id.r30, R.id.r31, R.id.r32, R.id.r33, R.id.r34),
            listOf(R.id.r40, R.id.r41, R.id.r42, R.id.r43, R.id.r44),
            listOf(R.id.r50, R.id.r51, R.id.r52, R.id.r53, R.id.r54))

        // inflate the list of buttons displaying the letters
        for (row in 0..5) {
            val list = mutableListOf<Button>()
            for (col in 0..4) {
                list.add(findViewById(letter_buttons_ids[row][col]))
            }
            letters.add(list)
        }

        val keys_ids = listOf(R.id.a, R.id.b, R.id.c, R.id.d, R.id.e, R.id.f, R.id.g, R.id.h, R.id.i,
            R.id.j, R.id.k, R.id.l, R.id.m, R.id.n, R.id.o, R.id.p, R.id.r, R.id.q,
            R.id.s, R.id.t, R.id.u, R.id.v, R.id.w, R.id.x, R.id.y, R.id.z)

        // listener object for all keys of the keyboard
        val listener = MyKeyListener()

        // initialise the keys to chars map
        for (k in keys_ids) {
            val b = findViewById<Button>(k)
            b.setOnClickListener(listener)
            keyMap.put(b, b.text.toString())
        }

        // setup the DEL button and listener
        delButton = findViewById<Button>(R.id.del)
        delButton.setOnClickListener(DelListener())

        // setup the ENTER button and listener
        enterButton = findViewById<Button>(R.id.enter)
        enterButton.setOnClickListener(EnterListener())

        // setup the Hints button and listener
        hintsButton = findViewById<Button>(R.id.hints)
        hintsButton.setOnClickListener(HintsListener())

        correct = findViewById<TextView>(R.id.answer)
    }


    // read all the words from the file in raw resources
    fun readFromFile() {
        val inputStream = resources.openRawResource(R.raw.words)
        val bf = BufferedReader(InputStreamReader(inputStream))

        var line: String?
        line = bf.readLine()

        while (line != null) {
            //Log.d("******", line)
            // add word to the list of words
            allWords.add(line.trim())

            line = bf.readLine()
        }
    }

    /* check the current word submitted by the user
       and update all the colours in both the user entry
       and the keyboard
       Returns true if submitted entry is a valid word, otherwise
       it returns false */
    fun checkGuess(): Boolean {
        // 1 - Genious
        // 2 - Magnificent
        // 3 - Impressive
        // 4 - Splendid
        // 5 - Great
        // 6 - Phew

        // pick up all the chars from the user entry
        var guess = ""
        for (b in letters[current_row])
            guess += b.text

        if (guess.lowercase() !in allWords) {
            correct.text = "This is an invalid word"
            return false
        }

        // Correct guess - do not accept any more answers
        if (guess.uppercase() == secret_word.uppercase()) {
            Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show()
            // make all of them green
            for (i in 0..wordSize-1)
                letters[current_row][i].setBackgroundColor(resources.getColor(R.color.green))
            current_row = number_of_attempts
        }
        else {
            Log.d("****", "guess: $guess.uppercase(), secret: ${secret_word.uppercase()}")
            for (i in 0..wordSize-1) {
                if (letters[current_row][i].text.toString().uppercase() == secret_word[i].toString().uppercase()) {
                    letters[current_row][i].setBackgroundColor(resources.getColor(R.color.green))
                    candidates[i] = mutableSetOf(secret_word[i])
                    included += letters[current_row][i].text.toString().elementAt(0).lowercaseChar()
                }
                else if (letters[current_row][i].text.toString().uppercase() in secret_word.uppercase()) {
                    letters[current_row][i].setBackgroundColor(resources.getColor(R.color.yellow))
                    candidates[i] -= mutableSetOf<Char>(letters[current_row][i].text.toString().elementAt(0).lowercaseChar())
                    included += letters[current_row][i].text.toString().elementAt(0).lowercaseChar()
                }
                else {
                    letters[current_row][i].setBackgroundColor(resources.getColor(R.color.grey))
                    excluded += letters[current_row][i].text.toString().elementAt(0).lowercaseChar()
                }
            }

            excluded -= included
            // remove excluded letters from the candidates
            for (i in 0..wordSize-1)
                candidates[i] -= excluded

            // Debug info
            Log.d("*****", "Candidates: $candidates")
        }

        return true
    }


    // Listener for the letter keys of the keyboard
    inner class MyKeyListener : View.OnClickListener {
        override fun onClick(v: View?) {
            if (current_col < wordSize && current_row < number_of_attempts) {
                letters[current_row][current_col].text = keyMap[(v as Button)]
                ++current_col
            }
        }
    }


    // Listener for the <Enter> button in the keyboard
    inner class EnterListener: View.OnClickListener {
        override fun onClick(v: View?) {
            Log.d("*******", "current row: $current_row,  current col: $current_col")
            if (current_row < number_of_attempts && current_col == wordSize) {
                val valid_submission = checkGuess()
                if (valid_submission) {
                    ++current_row
                    current_col = 0  // reset the column for the new user attempt
                }
            }

            // display the correct answer
            if (current_row == number_of_attempts)
                correct.text = secret_word.uppercase()
        }
    }

    // Listener for the DEL button in the keyboard
    inner class DelListener: View.OnClickListener {
        override fun onClick(v: View?) {
            correct.setText("")
            if (current_col > 0) {
                --current_col
                letters[current_row][current_col].text = ""
            }
        }
    }

    // Listener for the Hints button
    inner class HintsListener: View.OnClickListener {
        override fun onClick(v: View?) {
            val pattern = matchPattern()

            val intent = Intent(v?.context, Hints::class.java)
            intent.putExtra("pattern", pattern)
            startActivity(intent)
        }
    }


    // create a regular expression based on the candidates characters
    fun matchPattern(): String {
        var pattern = ""
        for (i in 0 until wordSize) {
            pattern += '['
            for (e in candidates[i])
                pattern += e
            pattern += ']'
        }

        // match only in the beginning and the end
        pattern = "^$pattern$"

        return pattern
    }
}