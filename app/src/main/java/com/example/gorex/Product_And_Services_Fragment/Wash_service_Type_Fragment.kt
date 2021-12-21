package com.example.gorex.Product_And_Services_Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gorex.databinding.FragmentWashServiceTypeBinding


class Wash_service_Type_Fragment : Fragment() {

    lateinit var washServiceTypeBinding: FragmentWashServiceTypeBinding
    var wash_service_types : List<String> = listOf("Hand Wash" , "Rin Wash" , "Full Wash" , "Car detailng")
    var wash_service_price : List<String> = listOf("99 SR" , "109 SR" ,"119 SR" , "129 SR")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        washServiceTypeBinding = FragmentWashServiceTypeBinding.inflate(inflater , container , false)

        val recyclerView = washServiceTypeBinding.fragmentWashServiceRecyclerview
        recyclerView.adapter= Serrvice_Type_Recycler_Adapter(wash_service_types , wash_service_price)
        recyclerView.layoutManager = LinearLayoutManager(context , LinearLayoutManager.VERTICAL , false)
        return washServiceTypeBinding.root
    }


}