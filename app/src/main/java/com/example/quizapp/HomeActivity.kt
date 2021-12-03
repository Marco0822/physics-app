package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        findViewById<Button>(R.id.exercise_button).setOnClickListener {
            val intent = Intent( this,load1::class.java)
            intent.putExtra("page_id","exercise")
            startActivity(intent)

        }
        findViewById<Button>(R.id.random_button).setOnClickListener {
            val intent = Intent( this, load1::class.java)
            intent.putExtra("page_id","leaderboard")
            startActivity(intent)
        }
        findViewById<Button>(R.id.statistics_button).setOnClickListener {
            val intent = Intent( this, load1::class.java)
            intent.putExtra("page_id","statistics")
            startActivity(intent)
        }
        findViewById<Button>(R.id.chat_button).setOnClickListener {
            val intent = Intent( this, load1::class.java)
            intent.putExtra("page_id","chat2")
            startActivity(intent)
        }
        editTextTextPersonName.setOnClickListener {
            val intent = Intent( this, DailyExercise::class.java)
            startActivity(intent)
        }
    }
}