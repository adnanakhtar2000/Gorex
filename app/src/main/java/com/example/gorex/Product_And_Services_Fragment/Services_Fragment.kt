package com.example.gorex.Product_And_Services_Fragment

import com.example.gorex.Adapters.service_recycler_Adapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gorex.R
import com.example.gorex.databinding.FragmentServicesBinding


class Services_Fragment : Fragment() {

    lateinit var servicesBinding: FragmentServicesBinding

    var service_image : List<Int> = listOf(R.drawable.car_engine_service , R.drawable.car_engine_service , R.drawable.car_engine_service)
    var service_name : List<String> = listOf("Car Wash Services" , "Car Engine Services" , "Car Electrical Services")
    var service_price : List<String> = listOf("99 SR" , "109 SR" , "88 SR")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        servicesBinding=FragmentServicesBinding.inflate(inflater , container , false)
        val recyclerView = servicesBinding.serviceFragmentRecyclerview
        recyclerView.adapter = service_recycler_Adapter(service_image , service_name , service_price)
        recyclerView.layoutManager= LinearLayoutManager(context , LinearLayoutManager.VERTICAL , false)

        return servicesBinding.root
    }


}