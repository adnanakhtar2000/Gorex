package com.example.gorex.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gorex.databinding.ActivityChangeProfileBinding

class Change_profile : AppCompatActivity() {

    private lateinit var change_profile_binding : ActivityChangeProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        change_profile_binding = ActivityChangeProfileBinding.inflate(layoutInflater)
        setContentView(change_profile_binding.root)

        change_profile_binding.saveProfileButton.setOnClickListener {
            val intent = Intent(this , Setting::class.java)
            startActivity(intent)
            overridePendingTransition(0,0)
        }

        change_profile_binding.changeProfileArrow.setOnClickListener{
            val intent = Intent(this , Setting::class.java)
            startActivity(intent)
            overridePendingTransition(0,0)
        }
    }
}