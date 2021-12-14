package com.example.gorex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.gorex.databinding.ActivitySignUpBinding
import kotlin.math.sign

class Sign_up : AppCompatActivity() {

    lateinit var signUpBinding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        signUpBinding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(signUpBinding.root)

        signUpBinding.signupButton.setOnClickListener{

            if (namevalidation() && lastname_validation() && mobile_number_validation() && email_validation() && password_validation() && confrim_password_validation()  ) {

                intent = Intent(this, Vechiles_Details::class.java)
                startActivity(intent)
            }
        }
    }

    private fun namevalidation() : Boolean {
        val name = signUpBinding.firstName1.text.toString().trim()

        if (name.isEmpty()){
            signUpBinding.firstName1.setError("Name Field Cannot be Empty")
            return false
        }
        else{
            return true
        }
    }

    private fun lastname_validation() : Boolean {
        val last_name = signUpBinding.lastName1.text.toString().trim()
        if (last_name.isEmpty()){
            signUpBinding.lastName1.setError("Field Cannot be Empty")
            return false
        }
        else    return true
    }
  private fun mobile_number_validation() : Boolean{
      val mobile_number =  signUpBinding.mobileNumber1.text.toString().trim()
      if (mobile_number.isEmpty() ){
          signUpBinding.mobileNumber1.setError("Mobile Number field must contain 11 number")
          return false

      }
      if (mobile_number.length<11 ){
          signUpBinding.mobileNumber1.setError("Mobile Number is Invalid")
          return false
      }
      else return true
  }

     private  fun email_validation() : Boolean{
        val email_validation = signUpBinding.email1.text.toString()

          val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"

        if (email_validation.isEmpty() ){
            signUpBinding.email1.setError("Email filed cannot be empty")
            return false
        }
        if (!email_validation.matches(emailPattern.toRegex()) ){
            signUpBinding.email1.setError("Email Adress in invalid")
            return false
        }
        else return true
    }

    private  fun password_validation() : Boolean{
        val password_validation = signUpBinding.signupPassword.text.toString().trim()
        val passwordPattern = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$"
        if (password_validation.isEmpty() ){
            signUpBinding.signupPassword.setError("Password Field must be fill" )
            return false
        }
        if (!password_validation.matches(passwordPattern.toRegex()) ){
            signUpBinding.signupPassword.setError("Password must Contain 1 upper case , 1 lower case , latters and at least 4 characters")
            return false
        }
        if (password_validation.length <8 ){
            signUpBinding.signupPassword.setError("Password must contain 8 words" )
            return false
        }
        else return true
    }
private  fun confrim_password_validation() : Boolean{
    val confirm_password = signUpBinding.confirmSignupPassword.text.toString().trim()
    val password = signUpBinding.signupPassword.text.toString()
    if (!confirm_password.matches(password.toRegex())){
        signUpBinding.confirmSignupPassword.setError("Password Not Match")
        return false
    }
    return true
}
}


