package com.example.gorex.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gorex.databinding.ActivityAddBinding
import com.example.gorex.payment_history_fragment.Payment_History

class Add_Activity : AppCompatActivity() {

    lateinit var  addBinding: ActivityAddBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addBinding = ActivityAddBinding.inflate(layoutInflater)
        setContentView(addBinding.root)
        addBinding.addButton.setOnClickListener{
            val intent = Intent(this , Payment_History::class.java)
            startActivity(intent)
        }
    }
}