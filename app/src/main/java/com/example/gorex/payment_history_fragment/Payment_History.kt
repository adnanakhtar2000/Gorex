package com.example.gorex.payment_history_fragment

import com.example.gorex.Adapters.Tab_Page_Adapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.example.gorex.databinding.ActivityPaymentHistoryBinding
import com.google.android.material.tabs.TabLayout

class Payment_History : AppCompatActivity() {

    lateinit var  paymentHistoryBinding: ActivityPaymentHistoryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        paymentHistoryBinding = ActivityPaymentHistoryBinding.inflate(layoutInflater)
        setContentView(paymentHistoryBinding.root)

        var viewpager : ViewPager = paymentHistoryBinding.viewpager1
        var tabLayout : TabLayout = paymentHistoryBinding.dwm2

        val tabPageAdapter = Tab_Page_Adapter(supportFragmentManager)
        tabPageAdapter.addfragment(Wallet_Fragment() , "Wallet")
        tabPageAdapter.addfragment(Card_Fragment() , "Card")
        tabPageAdapter.addfragment(Transection_Fragment() , "Transections")
        viewpager.adapter = tabPageAdapter
        tabLayout.setupWithViewPager(viewpager)

    }
}