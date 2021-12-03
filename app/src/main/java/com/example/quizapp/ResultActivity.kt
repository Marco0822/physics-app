package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_quiz_question.*
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        var username = intent.getStringExtra(Constants.USER_NAME)
        username = "Samsung123"
        val game_mode = intent.getStringExtra("game_mode")
        Log.i("Username", "${username}")
        tv_username.text = "Username: $username"

        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)
        val correctAnswer = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)
        val you_win = intent.getIntExtra(Constants.YOU_WIN, 8)

        if (game_mode=="practice") {
            tv_you_win.visibility = View.INVISIBLE
        }

        tv_score.text = "Score: $correctAnswer / $totalQuestions"
        if (you_win == 1) {
            tv_you_win.text = "Congratulations! You win! Score: + 10"
        } else if (you_win == 10) {
            tv_you_win.text = "Better luck next time! Opponent wins! Score: - 10"
        } else if (you_win == 3) {
            tv_you_win.text = "Tough match! Draw! Score: + 3"
        }


        btn_back.setOnClickListener{
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }


    }

}