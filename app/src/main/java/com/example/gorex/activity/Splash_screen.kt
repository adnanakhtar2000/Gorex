package com.example.gorex.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.gorex.CommonFunction
import com.example.gorex.databinding.ActivitySplashScreenBinding

class Splash_screen : AppCompatActivity() {

    private lateinit var splashScreenBinding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        splashScreenBinding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(splashScreenBinding.root)

        Handler().postDelayed({
            if(CommonFunction.getToken(applicationContext).length>10)
            {
                val intent = Intent(this, Navigation::class.java);
                startActivity(intent);
                finish();
            }
            else {
                val intent = Intent(this, Splash2::class.java);
                startActivity(intent);
                finish();
            }
        },3000)
    }
}