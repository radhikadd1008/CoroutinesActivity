package com.example.coroutinesactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log
import android.widget.Button
import android.widget.TextView
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    lateinit var timerTextView : TextView

    val startButton : Button by lazy {
        findViewById(R.id.button)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val scope = CoroutineScope(Job() + Dispatchers.Main)


        startButton.setOnClickListener {
            scope.launch {
                countdownTimer()
            }
        }


        }

    suspend fun countdownTimer() {
        timerTextView = findViewById<TextView>(R.id.timerTextView)
        repeat(100) {
            (100-it).toString().run {
                Log.d("Countdown", this)
                timerTextView.text = this
            }

            delay(1000)
        }
    }

    }