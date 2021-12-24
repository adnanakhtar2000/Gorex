package com.example.gorex.Response

import android.provider.ContactsContract

data class AddVehicleResponse(var status : Int,var message : String,var data : ArrayList<Vehicle>)
data class Vehicle(var vehicle_brand: String,var vehicle_model: String,var vehicle_Type: String,var year: String)