package com.example.gorex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gorex.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var mainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        mainBinding.signupButton.setOnClickListener{

            val intent = Intent(this , Sign_up::class.java)
            startActivity(intent)
        }

        mainBinding.loginButton.setOnClickListener{
            val intent = Intent(this , Navigation::class.java)
            startActivity(intent)
        }
    }
}