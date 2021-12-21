package com.example.gorex.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gorex.databinding.ActivityOtpVerficationBinding

class OTP_verfication : AppCompatActivity() {

    lateinit var otpVerficationBinding: ActivityOtpVerficationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        otpVerficationBinding = ActivityOtpVerficationBinding.inflate(layoutInflater)
        setContentView(otpVerficationBinding.root)

        otpVerficationBinding.otpButton.setOnClickListener{

            val intent = Intent(this , Login::class.java)
            startActivity(intent)
        }
    }
}