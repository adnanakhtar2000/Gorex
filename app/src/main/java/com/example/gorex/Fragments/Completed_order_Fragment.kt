package com.example.gorex.Fragments

import com.example.gorex.Adapters.Completed_order_adapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gorex.databinding.FragmentCompletedOrderBinding


class Completed_order_Fragment : Fragment() {

 lateinit var  completedOrderBinding: FragmentCompletedOrderBinding
val order_number : List<String> = listOf("A5409009801" , "A5409009801", "A5409009801")
 val provider_name : List<String> = listOf("Auto Master" , "Adnan" , "Workshop")
    val Payment_Method : List<String> = listOf("Cash" , "Wallet" , "Cash")
    val service_name : List<String> = listOf("Engine Oil" , "Oil Filter" , "Tyre Change")
    val payment : List<String> = listOf("500 SR" , "600 SR" , "800 SR")
    val date_time : List<String> = listOf("10 / 21 / 2021 , 03 : 30 PM" , "10 / 21 / 2021 , 03 : 30 PM" ,"10 / 21 / 2021 , 03 : 30 PM" )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        completedOrderBinding = FragmentCompletedOrderBinding.inflate(inflater, container, false)

        val recyclerView = completedOrderBinding.completedRecyclerview
        recyclerView.adapter = Completed_order_adapter(provider_name , Payment_Method , service_name , payment , date_time , order_number)
        recyclerView.layoutManager = LinearLayoutManager(context , LinearLayoutManager.VERTICAL , false
        )
        return completedOrderBinding.root
    }


}