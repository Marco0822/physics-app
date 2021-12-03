package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_difficulty_selection.*

class DifficultySelection : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_difficulty_selection)

        easy_button.setOnClickListener{
            val intent = Intent( this,GameMode::class.java)
            startActivity(intent)
        }
        medium_button.setOnClickListener{
            val intent = Intent( this,GameMode::class.java)
            startActivity(intent)
        }
        hard_button.setOnClickListener{
            val intent = Intent( this,GameMode::class.java)
            startActivity(intent)
        }
        automatic_button.setOnClickListener{
            val intent = Intent( this,GameMode::class.java)
            startActivity(intent)
        }


    }
}