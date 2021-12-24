package com.example.gorex.activity

import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.gorex.ApiClient.ApiClient
import com.example.gorex.ApiInterface.ApiInterface
import com.example.gorex.CommonFunction
import com.example.gorex.Response.AddVehicleResponse
import com.example.gorex.databinding.ActivitySignUpBinding
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.OutputStream
import java.util.*

class Sign_up : AppCompatActivity() {

    private lateinit var apiInterface: ApiInterface
    private lateinit var body: MultipartBody.Part
    private var file: File?= null
    lateinit var signUpBinding: ActivitySignUpBinding
    private val pickImage = 100
    private var imageUri: Uri? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        signUpBinding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(signUpBinding.root)
        apiInterface = ApiClient.create()

        signUpBinding.signupButton.setOnClickListener{

            if (namevalidation() && lastname_validation() && mobile_number_validation() && email_validation() && password_validation() && confrim_password_validation()  ) {
                //val inputStream = contentResolver.openInputStream(Uri.fromFile(file))
                val requestFile = RequestBody.create(MediaType.parse("image/jpeg"), file)
                body = MultipartBody.Part.createFormData("image", file!!.name, requestFile)
                val userType = RequestBody.create(MediaType.parse("text/plain"), "1")
                val firstName = RequestBody.create(MediaType.parse("text/plain"), signUpBinding.firstName1.text.toString())
                val lastName = RequestBody.create(MediaType.parse("text/plain"), signUpBinding.lastName1.text.toString())
                val name = RequestBody.create(MediaType.parse("text/plain"), signUpBinding.firstName1.text.toString()+" "+signUpBinding.lastName1.text.toString())
                val contact = RequestBody.create(MediaType.parse("text/plain"), signUpBinding.mobileNumber1.text.toString())
                val address = RequestBody.create(MediaType.parse("text/plain"), signUpBinding.addressEditText.text.toString())
                val password = RequestBody.create(MediaType.parse("text/plain"), signUpBinding.signupPassword.text.toString())
                val email = RequestBody.create(MediaType.parse("text/plain"), signUpBinding.email1.text.toString())
                val addVehicleResponse = apiInterface.userRegisterResponse(userType,name,email,password,contact,address,body,firstName,lastName)
                addVehicleResponse.enqueue( object : Callback<String> {
                    override fun onResponse(call: Call<String>?, response: Response<String>?) {

                        if(response?.body() != null) {
                            Toast.makeText(applicationContext,response.body().toString(), Toast.LENGTH_LONG).show()
                        }
                    }

                    override fun onFailure(call: Call<String>?, t: Throwable?) {
                        Toast.makeText(applicationContext,"Error...", Toast.LENGTH_LONG).show()
                    }
                })
                /*intent = Intent(this, Vechiles_Details::class.java)
                startActivity(intent)*/
            }
        }
        signUpBinding.imageView.setOnClickListener{
            val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            startActivityForResult(gallery, pickImage)
        }
    }
    private fun saveImageToInternalStorage(bitmap:Bitmap):File{
        // Get the image from drawable resource as drawable object
       /* val drawable = ContextCompat.getDrawable(applicationContext,drawableId)

        // Get the bitmap from drawable object
        val bitmap = (drawable as BitmapDrawable).bitmap*/

        // Get the context wrapper instance
        val wrapper = ContextWrapper(applicationContext)

        // Initializing a new file
        // The bellow line return a directory in internal storage
        var file = wrapper.getDir("images", Context.MODE_PRIVATE)


        // Create a file to save the image
        file = File(file, "${UUID.randomUUID()}.jpg")

        try {
            // Get the file output stream
            val stream: OutputStream = FileOutputStream(file)

            // Compress bitmap
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream)

            // Flush the stream
            stream.flush()

            // Close stream
            stream.close()
        } catch (e: IOException){ // Catch the exception
            e.printStackTrace()
        }

        // Return the saved image uri
        //return Uri.parse(file.absolutePath)
        return file
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && requestCode == pickImage) {
            imageUri = data?.data
                var bitmap: Bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), imageUri);
            file = saveImageToInternalStorage(bitmap)
            signUpBinding.imageView.setImageURI(Uri.parse(file!!.absolutePath))

            //signUpBinding.imageView.setImageURI(imageUri)
        }
    }

    private fun namevalidation() : Boolean {
        val name = signUpBinding.firstName1.text.toString().trim()
        val address = signUpBinding.addressEditText.text.toString().trim()

        if (name.isEmpty()){
            signUpBinding.firstName1.setError("Name Field Cannot be Empty")
            return false
        }
        if (address.isEmpty()){
            signUpBinding.addressEditText.setError("Address Field Cannot be Empty")
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


