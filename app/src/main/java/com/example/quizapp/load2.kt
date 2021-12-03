package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer

class load2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_load2)

        val currentActivity = this

        val timer = object: CountDownTimer(2500, 100) {
            override fun onTick(millisUntilFinished: Long){}
            override fun onFinish() {
                val intent = Intent(currentActivity,QuizQuestionActivity::class.java)
                intent.putExtra("game_mode", "pvp")
                intent.putExtra(Constants.USER_NAME, "Marco")
                startActivity(intent)
            }
        }
        timer.start()
    }
}