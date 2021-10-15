package com.example.test1


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.content.Intent



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        findViewById<Button>(R.id.exercise_button).setOnClickListener {
            val intent = Intent( this, exercise::class.java)
            startActivity(intent)
        }
        findViewById<Button>(R.id.random_button).setOnClickListener {
            val intent = Intent( this, leaderboard::class.java)
            startActivity(intent)
        }
        findViewById<Button>(R.id.statistics_button).setOnClickListener {
            val intent = Intent( this, statistics::class.java)
            startActivity(intent)
        }



    }
}
