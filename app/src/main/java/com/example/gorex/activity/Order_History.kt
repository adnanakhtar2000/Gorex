package com.example.gorex.activity

import com.example.gorex.Adapters.Tab_Page_Adapter
import com.example.gorex.Fragments.Cancelled_order_Fragment
import com.example.gorex.Fragments.Completed_order_Fragment
import com.example.gorex.Fragments.InComplete_Order_Fragment
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.example.gorex.databinding.ActivityOrderHistoryBinding

class Order_History : AppCompatActivity() {

    lateinit var orderHistoryBinding: ActivityOrderHistoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        orderHistoryBinding = ActivityOrderHistoryBinding.inflate(layoutInflater)
        setContentView(orderHistoryBinding.root)
        var viewpager : ViewPager = orderHistoryBinding.viewpager
        var tablayout = orderHistoryBinding.dwm1

        val fragmentPage_Adapter = Tab_Page_Adapter(supportFragmentManager)
        fragmentPage_Adapter.addfragment(Completed_order_Fragment() , "Completed")
        fragmentPage_Adapter.addfragment(InComplete_Order_Fragment() , "Uncomplete")
        fragmentPage_Adapter.addfragment(Cancelled_order_Fragment() , "Cancelled")
        viewpager.adapter = fragmentPage_Adapter
        tablayout.setupWithViewPager(viewpager)

    }
}




