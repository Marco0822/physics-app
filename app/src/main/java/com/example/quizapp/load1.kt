package com.example.quizapp

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity

class load1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_load1)
        val currentActivity = this

        val checker = intent.getStringExtra("page_id")
        //TimeUnit.SECONDS.sleep(1L)
        val timer = object: CountDownTimer(2500, 100) {
            override fun onTick(millisUntilFinished: Long){}
            override fun onFinish() {
                if (checker == "exercise") {
                    val intent = Intent(currentActivity, exercise::class.java)
                    startActivity(intent)
                }
                if (checker == "statistics") {
                    val intent = Intent(currentActivity, statistics::class.java)
                    startActivity(intent)

                }
                if (checker == "leaderboard") {
                    val intent = Intent(currentActivity, leaderboard::class.java)
                    startActivity(intent)

                }
                if (checker == "chat2") {
                    val intent = Intent(currentActivity, chat2::class.java)
                    startActivity(intent)

                }
            }
        }

        timer.start()

    }
}