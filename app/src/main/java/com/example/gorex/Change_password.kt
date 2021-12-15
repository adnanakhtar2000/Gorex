package com.example.gorex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gorex.databinding.ActivityChangePasswordBinding

class Change_password : AppCompatActivity() {

    private lateinit var changePasswordBinding: ActivityChangePasswordBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        changePasswordBinding = ActivityChangePasswordBinding.inflate(layoutInflater)
        setContentView(changePasswordBinding.root)
        changePasswordBinding.changePasseordSetting.setOnClickListener{
            val intent = Intent(this , Setting::class.java)
            startActivity(intent)
            overridePendingTransition(0,0)
        }
        changePasswordBinding.changePasswordArrow.setOnClickListener{
            val intent = Intent(this , Setting::class.java)
            startActivity(intent)
            overridePendingTransition(0,0)
        }
    }
}