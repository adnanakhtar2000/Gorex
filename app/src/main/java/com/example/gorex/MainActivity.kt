package com.example.gorex

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.gorex.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var mainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        mainBinding.signupButton.setOnClickListener{



                intent = Intent(this, Sign_up::class.java)
                startActivity(intent)

        }

        mainBinding.loginButton.setOnClickListener {


            if (mobile_validation() && password_validation()) {

                intent = Intent(this, Navigation::class.java)
                startActivity(intent)
            }
        }
    }

private fun mobile_validation(): Boolean{
    val mobile_number = mainBinding.mobileNumber1.text.toString().trim()
    if (mobile_number.isEmpty()  ){
        mainBinding.mobileNumber1.setError("Phone Number must be Entered")
        return false
    }
    if (mobile_number.length < 11  ){
        mainBinding.mobileNumber1.setError("Phone Number is Invalid")
        return false
    }
    else{
        return true
    }
}


    private  fun password_validation(): Boolean{
        val password_validation = mainBinding.passwordLogin.text.toString().trim()
        if (password_validation.isEmpty() ){
            mainBinding.passwordLogin.setError("Password must be Entered")
            return false
        }
        else{
            return true
        }
    }
}