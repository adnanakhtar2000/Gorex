package com.example.gorex.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.gorex.ApiClient.ApiClient
import com.example.gorex.ApiInterface.ApiInterface
import com.example.gorex.CommonFunction
import com.example.gorex.Response.LoginResponse
import com.example.gorex.databinding.ActivityLoginBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Login : AppCompatActivity() {

    private lateinit var apiInterface: ApiInterface
    private lateinit var loginBinding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    loginBinding=ActivityLoginBinding.inflate(layoutInflater)
       setContentView(loginBinding.root)
        apiInterface = ApiClient.create()
        loginBinding.loginButton.setOnClickListener{
            val loginResponse = apiInterface.getLoginResponse(loginBinding.mobileNumber1.text.toString(),loginBinding.passwordEditText.text.toString())
            loginResponse.enqueue( object : Callback<LoginResponse> {
                override fun onResponse(call: Call<LoginResponse>?, response: Response<LoginResponse>?) {

                    if(response?.body() != null && response.body()!!.data != null)
                    {

                        CommonFunction.saveToken(applicationContext, response.body()!!.data.get(0).Token)
                       // CommonFunction.saveName(applicationContext, response.body()!!.data.first_name+" "+response.body()!!.data.last_name)

                        overridePendingTransition(0,0)

                        val intent = Intent(applicationContext , Navigation::class.java)
                            startActivity(intent)
                            finish()
                            overridePendingTransition(0, 0)

                    }
                    else
                        Toast.makeText(applicationContext,"Invalid Email and Password...", Toast.LENGTH_LONG).show();
                }

                override fun onFailure(call: Call<LoginResponse>?, t: Throwable?) {

                }
            })

        }


    }
}