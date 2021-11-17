package com.example.gorex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gorex.databinding.ActivityTopupWallet1Binding
import payment_history_fragment.Payment_History

class Topup_Wallet1 : AppCompatActivity() {

    lateinit var topupWallet1Binding: ActivityTopupWallet1Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        topupWallet1Binding = ActivityTopupWallet1Binding.inflate(layoutInflater)
        setContentView(topupWallet1Binding.root)

        topupWallet1Binding.topupButton1.setOnClickListener{
            val intent = Intent(this , Payment_History::class.java)
            startActivity(intent)
        }
    }
}