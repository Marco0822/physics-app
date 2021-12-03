package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_exercise.*

class exercise : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise)
        math_button.setOnClickListener {
            val intent = Intent( this, mathematics::class.java)
            startActivity(intent)
        }
        phy_button.setOnClickListener {
            Toast.makeText(this, "Work in progress ...", Toast.LENGTH_SHORT).show()
        }
        chem_button.setOnClickListener{
            Toast.makeText(this, "Work in progress ...", Toast.LENGTH_SHORT).show()
        }
        bio_button.setOnClickListener{
            Toast.makeText(this, "Work in progress ...", Toast.LENGTH_SHORT).show()
        }
    }

}