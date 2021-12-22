package com.example.gorex.activity

import com.example.gorex.Adapters.Order_TypeAdapter
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gorex.R
import com.example.gorex.databinding.ActivityNavigationBinding
import com.example.gorex.payment_history_fragment.Payment_History
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import org.json.JSONArray

class Navigation : AppCompatActivity()   {

    private lateinit var navigationBinding: ActivityNavigationBinding
    val order_type: List<String> =
        listOf("Fuel Refill", "Engine Oil", "Transmission Oil", "Car Battery")
    val order_image: List<Int> = listOf(
        R.drawable.fuel_refill_selector,
        R.drawable.engine_oil_selector,
        R.drawable.transmission_oil_selector,
        R.drawable.battery_selector
    )


    lateinit var googleMap: Google_map

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navigationBinding = ActivityNavigationBinding.inflate(layoutInflater)
        setContentView(navigationBinding.root)




        navigationBinding.circleView.setOnClickListener {

            navigationBinding.drawerLayout.openDrawer(GravityCompat.START)


        }


        //        navigationBinding.navView.setNavigationItemSelectedListener(this)

        googleMap = Google_map()
        supportFragmentManager.beginTransaction().replace(R.id.container, googleMap).commit()


        val recyclerView = navigationBinding.recyclerView
        recyclerView.adapter = Order_TypeAdapter(order_type, order_image)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true)

navigationBinding.navView.setNavigationItemSelectedListener{
    when(it.itemId){
        R.id.left_order_history -> {

            val intent = Intent(applicationContext, Order_History::class.java)
            startActivity(intent)
            overridePendingTransition(0,0)
        }

        R.id.left_paymetn_history -> {

            val intent1 = Intent(applicationContext, Payment_History::class.java)
            startActivity(intent1)
            overridePendingTransition(0,0)
        }
        R.id.left_my_vehicle -> {
            val intent2 = Intent(applicationContext, My_Vehicle::class.java)
            startActivity(intent2)
            overridePendingTransition(0,0)
        }
        R.id.left_setting ->{
        val intent3 = Intent(applicationContext, Setting::class.java)
            startActivity(intent3)
            overridePendingTransition(0,0)
        }
        R.id.left_contact_us ->{
            val intent3 = Intent(applicationContext, Contact_Us::class.java)
            startActivity(intent3)
            overridePendingTransition(0,0)
        }
        R.id.left_about ->{
            val intent3 = Intent(applicationContext, About::class.java)
            startActivity(intent3)
            overridePendingTransition(0,0)
        }

    }

    navigationBinding.drawerLayout.closeDrawer(GravityCompat.START)
    return@setNavigationItemSelectedListener true
    }
}
}