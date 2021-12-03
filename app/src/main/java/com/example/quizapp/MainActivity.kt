package com.example.quizapp

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.WindowInsets
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_start.setOnClickListener {
            if(et_name.text.toString().isEmpty()) {
                Toast.makeText(this, "Please enter your name!", Toast.LENGTH_SHORT).show()
            } else if (et_password.text.toString().isEmpty()){
                Toast.makeText(this, "Please enter the password!", Toast.LENGTH_SHORT).show()
            } else if ((et_password.text.toString() != "SSC123") or (et_name.text.toString() != "Samsung123")){
                Toast.makeText(this, "Wrong username or password!", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, HomeActivity::class.java)
                intent.putExtra(Constants.USER_NAME, et_name.text.toString())
                startActivity(intent)
                finish() // close current activity
            }
        }

    }
}