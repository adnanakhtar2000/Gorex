package com.example.gorex.ApiInterface

import com.example.gorex.Response.AddVehicleResponse
import com.example.gorex.Response.LoginResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface ApiInterface {
    @FormUrlEncoded
    @POST("autohub/authentication/user/login")
    fun getLoginResponse(@Field("email") email: String,
                         @Field("password") password: String) : Call<LoginResponse>

    @FormUrlEncoded
    @POST("autohub/service-provider/vehicle-management/customer-vehicle")
    fun addVehicle(@Header("Authorization") header: String,@Field("vehicle_brand") vehicleBrand: String, @Field("vehicle_model") vehicleModel: String, @Field("vehicle_Type") vehicleType: String,
                   @Field("year") years: String,@Field("number_plate") nPlate: String,@Field("engine_chesis_number") engineNumber: String) : Call<AddVehicleResponse>

    @Multipart //@Part("picture\"; filename=\"pp.png") RequestBody file
    @POST("autohub/customer/profile")
    fun userRegisterResponse(@Part("user_type") user_type: RequestBody,
                             @Part("name") name: RequestBody, @Part("email") email: RequestBody,
                             @Part("password") password: RequestBody,
                             @Part("contact_number") CNumber: RequestBody,
                             @Part("address") address: RequestBody,
                             @Part("image") image: MultipartBody.Part,
                             @Part("first_name") fName: RequestBody,
                             @Part("last_name") LName: RequestBody) : Call<String>

    @FormUrlEncoded
    @POST("package")
    fun createSpecialOffer(@Header("Authorization") header: String,@Field("number_of_sessions") number: Int,@Field("price") price: String) : Call<String>    @FormUrlEncoded

    @POST("bank")
    fun createBankDetail(@Header("Authorization") header: String,@Field("bank_name") name: String,@Field("branch_name") branchName: String,@Field("account_number") accountNumber: String,@Field("account_title") accountTitle: String,@Field("iban") iban: String) : Call<String>

}