package com.example.gorex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gorex.databinding.ActivityNotificationsSettingBinding

class Notifications_Setting : AppCompatActivity() {

    lateinit var notificationsSettingBinding: ActivityNotificationsSettingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        notificationsSettingBinding = ActivityNotificationsSettingBinding.inflate(layoutInflater)
        setContentView(notificationsSettingBinding.root)

        notificationsSettingBinding.notificationSettingArrow.setOnClickListener{
            val intent = Intent(this , Setting::class.java)
            startActivity(intent)
            overridePendingTransition(0,0)
        }
    }
}