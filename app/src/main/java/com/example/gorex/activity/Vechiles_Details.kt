package com.example.gorex.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.gorex.ApiClient.ApiClient
import com.example.gorex.ApiInterface.ApiInterface
import com.example.gorex.CommonFunction
import com.example.gorex.R
import com.example.gorex.Response.AddVehicleResponse
import com.example.gorex.Response.LoginResponse
import com.example.gorex.databinding.ActivityVechilesDetailsBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Vechiles_Details : AppCompatActivity() {

    private var isVehicle: Boolean = false
    private lateinit var apiInterface: ApiInterface
    lateinit var vechilesDetailsBinding: ActivityVechilesDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vechilesDetailsBinding = ActivityVechilesDetailsBinding.inflate(layoutInflater)
        setContentView(vechilesDetailsBinding.root)
        isVehicle = intent.getBooleanExtra("isAddVehicle",false)
        apiInterface = ApiClient.create()
        vechilesDetailsBinding.signupButton.setOnClickListener{
            if(validation())
            {
                val addVehicleResponse = apiInterface.addVehicle(CommonFunction.getToken(applicationContext),vechilesDetailsBinding.brand.selectedItem.toString(),vechilesDetailsBinding.model.text.toString(),vechilesDetailsBinding.type.selectedItem.toString(),vechilesDetailsBinding.years.text.toString(),vechilesDetailsBinding.nPlate.text.toString(),vechilesDetailsBinding.chesisNumber.text.toString())
                addVehicleResponse.enqueue( object : Callback<AddVehicleResponse> {
                    override fun onResponse(call: Call<AddVehicleResponse>?, response: Response<AddVehicleResponse>?) {

                        if(response?.body() != null && response.body()!!.data != null)
                        {
                            if(response.body()!!.data.size>0 && isVehicle)
                                finish()
                            else {
                                val intent = Intent(applicationContext , OTP_verfication::class.java)
                                startActivity(intent)
                            }

                        }
                    }

                    override fun onFailure(call: Call<AddVehicleResponse>?, t: Throwable?) {
                        Toast.makeText(applicationContext,"Error...", Toast.LENGTH_LONG).show();
                    }
                })
            }
            /*val intent = Intent(this , OTP_verfication::class.java)
            startActivity(intent)*/
        }

        val vechile_brands = resources.getStringArray(R.array.Vehicle_Type)
        val spinners = vechilesDetailsBinding.brand
        val adapter = ArrayAdapter(this , R.layout.selected_dropdown, vechile_brands)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinners.adapter = adapter

        val vechile_types = resources.getStringArray(R.array.vehicle_types1)
        val spinners1 = vechilesDetailsBinding.type
        val adapter1 = ArrayAdapter(this , R.layout.selected_dropdown, vechile_types)
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinners1.adapter = adapter1

    }
    private fun validation() : Boolean {
        val model = vechilesDetailsBinding.model.text.toString().trim()
        val years = vechilesDetailsBinding.years.text.toString().trim()
        val nPlate = vechilesDetailsBinding.nPlate.text.toString().trim()
        val chesisNumber = vechilesDetailsBinding.chesisNumber.text.toString().trim()

        if (model.isEmpty()){
            vechilesDetailsBinding.model.setError("Model Field Cannot be Empty")
            return false
        }
        if (years.isEmpty()){
            vechilesDetailsBinding.years.setError("Registration Field Cannot be Empty")
            return false
        }
        if (nPlate.isEmpty()){
            vechilesDetailsBinding.nPlate.setError("Number Plate Field Cannot be Empty")
            return false
        }
        return if (chesisNumber.isEmpty()){
            vechilesDetailsBinding.chesisNumber.setError("Chesis Number Cannot be Empty")
            false
        } else{
            true
        }
    }
}