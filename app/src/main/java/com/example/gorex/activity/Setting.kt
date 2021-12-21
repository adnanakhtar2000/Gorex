package com.example.gorex.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gorex.databinding.ActivitySettingBinding

class Setting : AppCompatActivity() {
    lateinit var settingbinding : ActivitySettingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        settingbinding = ActivitySettingBinding.inflate(layoutInflater)
        setContentView(settingbinding.root)
        settingbinding.changePasswordButton.setOnClickListener{
            val intent = Intent(this , Change_password::class.java)
            startActivity(intent)
            overridePendingTransition(0,0)
        }
       settingbinding.changeProfileButton.setOnClickListener{
            val intent = Intent(this , Change_profile::class.java)
            startActivity(intent)
        }
        settingbinding.notifications.setOnClickListener {
            val intent = Intent(this , Notifications_Setting::class.java)
            startActivity(intent)
        }

        settingbinding.settingArrow.setOnClickListener{
            val intent = Intent( this , Navigation::class.java)
            startActivity(intent)
            overridePendingTransition(0,0)
        }
    }
}