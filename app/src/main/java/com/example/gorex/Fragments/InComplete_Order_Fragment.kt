package com.example.gorex.Fragments

import com.example.gorex.Adapters.Uncompleted_order_adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gorex.databinding.FragmentInCompleteOrderBinding


class InComplete_Order_Fragment : Fragment() {
    val order_number_uc : List<String> = listOf("A5409009801" , "A5409009801")
    val provider_name_uc : List<String> = listOf("Auto Master" , "Adnan" )
    val Payment_Method_uc : List<String> = listOf("Cash" , "Wallet" )
    val service_name_uc : List<String> = listOf("Engine Oil" , "Oil Filter" )
    val payment_uc : List<String> = listOf("500 SR" , "600 SR" )
    val date_time_uc : List<String> = listOf("10 / 21 / 2021 , 03 : 30 PM" , "10 / 21 / 2021 , 03 : 30 PM"  )

lateinit var inCompleteOrderBinding: FragmentInCompleteOrderBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        inCompleteOrderBinding = FragmentInCompleteOrderBinding.inflate(inflater, container, false)
        val recyclerView = inCompleteOrderBinding.uncompletedRecyclerview
        recyclerView.adapter = Uncompleted_order_adapter (provider_name_uc , Payment_Method_uc , service_name_uc , payment_uc , date_time_uc , order_number_uc)
        recyclerView.layoutManager = LinearLayoutManager(context , LinearLayoutManager.VERTICAL , false
        )
        return inCompleteOrderBinding.root
    }


}