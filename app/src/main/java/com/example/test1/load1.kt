package com.example.test1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.concurrent.TimeUnit

class load1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_load1)
        //val random_number = (1..4).random()
        val checker = intent.getStringExtra("page_id")
        TimeUnit.SECONDS.sleep(1L)
        if (checker == "exercise") {
            val intent = Intent(this, exercise::class.java)
            startActivity(intent)
        }
        if (checker == "statistics") {
            val intent = Intent(this, statistics::class.java)
            startActivity(intent)

        }
        if (checker == "leaderboard") {
            val intent = Intent(this, leaderboard::class.java)
            startActivity(intent)

        }
        if (checker == "chat2") {
            val intent = Intent(this, chat2::class.java)
            startActivity(intent)

        }
    }
}