package com.example.gorex

import Adapters.Order_parts_recycler_Adapter
import Adapters.Product_recycler_Adapter
import Adapters.service_recycler_Adapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gorex.databinding.FragmentOrdersDetailsBinding

class Orders_Details_Fragment : Fragment() {

lateinit var ordersDetailsBinding: FragmentOrdersDetailsBinding

val orders_name : List<String> = listOf("Air Filter Toyota" , "Air Filter Toyota" , "Air Filter Toyota")
    val orders_price : List<String> = listOf("200 SR", "200 SR", "200 SR")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       ordersDetailsBinding = FragmentOrdersDetailsBinding.inflate(inflater , container , false)

        val recyclerView = ordersDetailsBinding.orderDetailsPartRecylerview
        recyclerView.adapter = Order_parts_recycler_Adapter(orders_name , orders_price)
        recyclerView.layoutManager= LinearLayoutManager(context , LinearLayoutManager.VERTICAL , false)
        return ordersDetailsBinding.root
    }

}