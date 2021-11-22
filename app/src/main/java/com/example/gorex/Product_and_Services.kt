package com.example.gorex

import Adapters.Product_and_services_tab_Adapter
import Product_And_Services_Fragment.Product_Fragment
import Product_And_Services_Fragment.Services_Fragment
import Product_And_Services_Fragment.Wash_service_Type_Fragment
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gorex.databinding.ActivityProductAndServicesBinding

class Product_and_Services : AppCompatActivity() {

    lateinit var productAndServicesBinding: ActivityProductAndServicesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        productAndServicesBinding= ActivityProductAndServicesBinding.inflate(layoutInflater)
        setContentView(productAndServicesBinding.root)

        var viewPager = productAndServicesBinding.productAndServicesViewpager
        var tabLayout = productAndServicesBinding.dwm3

        val productAndServicesTabAdapter = Product_and_services_tab_Adapter(supportFragmentManager)
        productAndServicesTabAdapter.addfragments(Product_Fragment() , "Product")
        productAndServicesTabAdapter.addfragments(Wash_service_Type_Fragment(), "Services")
        viewPager.adapter=productAndServicesTabAdapter
        tabLayout.setupWithViewPager(viewPager)
    }
}