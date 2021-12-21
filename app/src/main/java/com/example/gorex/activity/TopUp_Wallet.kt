package com.example.gorex.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gorex.databinding.ActivityTopUpWalletBinding

class TopUp_Wallet : AppCompatActivity() {
    lateinit var topUpWalletBinding: ActivityTopUpWalletBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        topUpWalletBinding = ActivityTopUpWalletBinding.inflate(layoutInflater)
        setContentView(topUpWalletBinding.root)
        topUpWalletBinding.topupButton.setOnClickListener{
            val intent =Intent(this , Topup_Wallet1::class.java)
            startActivity(intent)
        }


    }
}