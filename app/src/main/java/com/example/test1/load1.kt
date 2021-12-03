package com.example.test1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import java.util.concurrent.TimeUnit

class load1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_load1)
        //val random_number = (1..4).random()

        val checker = intent.getStringExtra("page_id")
        //TimeUnit.SECONDS.sleep(1L)
        val timer = object: CountDownTimer(2500, 100) {
            override fun onTick(millisUntilFinished: Long){}
            override fun onFinish() {
                if (checker == "exercise") {
                    val intent = Intent(this@load1, exercise::class.java)
                    startActivity(intent)
                }
                if (checker == "statistics") {
                    val intent = Intent(this@load1, statistics::class.java)
                    startActivity(intent)

                }
                if (checker == "leaderboard") {
                    val intent = Intent(this@load1, leaderboard::class.java)
                    startActivity(intent)

                }
                if (checker == "chat2") {
                    val intent = Intent(this@load1, chat2::class.java)
                    startActivity(intent)

                }
            }
        }

        timer.start()
    }
}