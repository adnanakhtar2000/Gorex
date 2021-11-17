package com.example.gorex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.gorex.databinding.ActivityVechilesDetailsBinding

class Vechiles_Details : AppCompatActivity() {

    lateinit var vechilesDetailsBinding: ActivityVechilesDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vechilesDetailsBinding = ActivityVechilesDetailsBinding.inflate(layoutInflater)
        setContentView(vechilesDetailsBinding.root)

        vechilesDetailsBinding.signupButton.setOnClickListener{
            val intent = Intent(this , OTP_verfication::class.java)
            startActivity(intent)
        }

        val vechile_brands = resources.getStringArray(R.array.Vehicle_Type)
        val spinners = vechilesDetailsBinding.firstName1
        val adapter = ArrayAdapter(this , R.layout.selected_dropdown, vechile_brands)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinners.adapter = adapter

        val vechile_types = resources.getStringArray(R.array.vehicle_types1)
        val spinners1 = vechilesDetailsBinding.mobileNumber1
        val adapter1 = ArrayAdapter(this , R.layout.selected_dropdown , vechile_types)
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinners1.adapter = adapter1

    }
}