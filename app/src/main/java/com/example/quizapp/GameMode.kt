package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_game_mode.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_mathematics.*

class GameMode : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_mode)

        btn_practice.setOnClickListener{
            val intent = Intent( this,QuizQuestionActivity::class.java)
            intent.putExtra("game_mode", "practice")
            intent.putExtra(Constants.USER_NAME, "Marco")
            startActivity(intent)
        }

        btn_pvp.setOnClickListener{
            val intent = Intent( this,load2::class.java)
            startActivity(intent)
        }

    }
}