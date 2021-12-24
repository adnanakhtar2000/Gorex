package com.example.gorex.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.gorex.R
import com.example.gorex.databinding.ActivityMyVehicleBinding
import com.example.gorex.databinding.ActivityVechilesDetailsBinding

class My_Vehicle : AppCompatActivity() {
    private lateinit var myVechiles: ActivityMyVehicleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        myVechiles = ActivityMyVehicleBinding.inflate(layoutInflater)
        setContentView(myVechiles.root)
        myVechiles.addVehicle.setOnClickListener(View.OnClickListener {
            val intent = Intent(this , Vechiles_Details::class.java)
            intent.putExtra("isAddVehicle",true)
            startActivity(intent)
        })
        //setContentView(R.layout.activity_my_vehicle)
    }
}