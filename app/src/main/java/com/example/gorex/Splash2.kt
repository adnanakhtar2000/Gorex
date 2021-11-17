package com.example.gorex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.gorex.databinding.ActivitySplash2Binding

class Splash2 : AppCompatActivity() {

lateinit var splash2Binding: ActivitySplash2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        splash2Binding = ActivitySplash2Binding.inflate(layoutInflater)

        setContentView(splash2Binding.root)

        splash2Binding.splashNext.setOnClickListener{

            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
        val language = resources.getStringArray(R.array.language)
        val spinners = splash2Binding.seletLanguage
        val adapter = ArrayAdapter(this , R.layout.selected_dropdown, language)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinners.adapter = adapter
    }
}