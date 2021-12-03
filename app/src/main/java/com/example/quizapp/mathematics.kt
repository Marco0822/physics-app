package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_game_mode.*
import kotlinx.android.synthetic.main.activity_mathematics.*

class mathematics : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mathematics)

        math_ch1_button.setOnClickListener{
            val intent = Intent( this,GameMode::class.java)
            startActivity(intent)
        }
    }
}