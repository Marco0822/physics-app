package com.example.test1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class exercise : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise)
        findViewById<Button>(R.id.phy_button).setOnClickListener {
            val intent = Intent( this, phy_exercise::class.java)
            startActivity(intent)
        }
        findViewById<Button>(R.id.chem_button).setOnClickListener {
            val intent = Intent( this, chem_exercise::class.java)
            startActivity(intent)
        }
        findViewById<Button>(R.id.math_button).setOnClickListener {
            val intent = Intent( this, math_exercise::class.java)
            startActivity(intent)
        }
        findViewById<Button>(R.id.bio_button).setOnClickListener {
            val intent = Intent( this, bio_exercise::class.java)
            startActivity(intent)
        }

    }

}