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
            val intent = Intent( this,chat::class.java)
            intent.putExtra("page_id","exercise")
            startActivity(intent)
        }
        findViewById<Button>(R.id.random_button).setOnClickListener {
            val intent = Intent( this, load::class.java)
            intent.putExtra("page_id","leaderboard")
            startActivity(intent)
        }
        findViewById<Button>(R.id.statistics_button).setOnClickListener {
            val intent = Intent( this, load::class.java)
            intent.putExtra("page_id","statistics")
            startActivity(intent)
        }
        findViewById<Button>(R.id.chat_button).setOnClickListener {
            val intent = Intent( this, load::class.java)
            intent.putExtra("page_id","chat")
            startActivity(intent)
        }



    }
}
