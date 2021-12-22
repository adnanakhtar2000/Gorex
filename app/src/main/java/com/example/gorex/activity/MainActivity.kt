package com.example.gorex.activity

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.gorex.ApiClient.ApiClient
import com.example.gorex.ApiInterface.ApiInterface
import com.example.gorex.CommonFunction
import com.example.gorex.Response.LoginResponse
import com.example.gorex.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var apiInterface: ApiInterface
    lateinit var mainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        apiInterface = ApiClient.create()
        mainBinding.signupButton.setOnClickListener{

                intent = Intent(this, Sign_up::class.java)
                startActivity(intent)

        }

        mainBinding.loginButton.setOnClickListener {


            if (emailValidation() && password_validation()) {

                val loginResponse = apiInterface.getLoginResponse(mainBinding.mobileNumber1.text.toString(),mainBinding.passwordLogin.text.toString())
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
                        Toast.makeText(applicationContext,"Invalid Email and Password...", Toast.LENGTH_LONG).show();
                    }
                })
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
    private fun emailValidation(): Boolean{
        val email = mainBinding.mobileNumber1.text.toString().trim()
        if (email.isEmpty()  ){
            mainBinding.mobileNumber1.setError("Email must be Entered")
            return false
        }
        return if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            mainBinding.mobileNumber1.setError("Email is Invalid")
            false
        } else{
            true
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