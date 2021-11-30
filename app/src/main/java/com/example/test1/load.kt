package com.example.test1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class load : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_load)
        val random_number = (1..4).random()
        Thread.sleep(random_number.toLong())
        val checker = intent.getStringExtra("page_id")
        if (checker == "exercise") {
            val intent = Intent(this, exercise::class.java)
            startActivity(intent)
        }
    }
}
