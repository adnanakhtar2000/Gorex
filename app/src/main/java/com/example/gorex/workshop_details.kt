package com.example.gorex

import Adapters.Workshop_services_Adapter
import Interfaces.cellclicklistner
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gorex.databinding.ActivityWorkshopDetailsBinding

class workshop_details : AppCompatActivity() , cellclicklistner {
    lateinit var workshopDetailsBinding: ActivityWorkshopDetailsBinding
    var services_logo : List<Int> = listOf(R.drawable.ic_noun_car_battery_2082376 , R.drawable.ic_noun_engine_oil_1979324 , R.drawable.ic_noun_car_transmission_1563498 ,R.drawable.ic_noun_fuel_780293 , R.drawable.ic_noun_car_oil_filter_3189909 )
    var services_name : List<String> = listOf("Battery" , "Engine Oil" , "Transmission Oil" , "Fuel Change" , "Filter Change")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        workshopDetailsBinding = ActivityWorkshopDetailsBinding.inflate(layoutInflater)
        setContentView(workshopDetailsBinding.root)

        val recyclerView = workshopDetailsBinding.ourServicesRecyclerView
        recyclerView.adapter = Workshop_services_Adapter(this, this, services_logo , services_name)
        recyclerView.layoutManager= GridLayoutManager(this , 2, LinearLayoutManager.VERTICAL , false)
    }

    override fun onCellClickListener() {
        val intent = Intent(this , Product_and_Services::class.java)
        startActivity(intent)
    }
}