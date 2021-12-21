package com.example.gorex.payment_history_fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gorex.activity.TopUp_Wallet
import com.example.gorex.databinding.FragmentWalletBinding

class Wallet_Fragment : Fragment() {

    lateinit var walletBinding: FragmentWalletBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        walletBinding = FragmentWalletBinding.inflate(inflater , container , false)

        walletBinding.plusWallet.setOnClickListener{

            requireActivity().run {
                startActivity(Intent(this, TopUp_Wallet::class.java))
                finish()
                overridePendingTransition(0,0)
            }
        }
        return walletBinding.root
    }

    
}