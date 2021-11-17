package com.example.gorex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gorex.databinding.ActivitySignUpBinding

class Sign_up : AppCompatActivity() {

    lateinit var signUpBinding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        signUpBinding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(signUpBinding.root)

        signUpBinding.signupButton.setOnClickListener{
            val intent = Intent(this , Vechiles_Details::class.java)
            startActivity(intent)

        }
    }
}