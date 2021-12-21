package com.example.gorex.ApiInterface

import com.example.gorex.Response.LoginResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiInterface {
    @FormUrlEncoded
    @POST("autohub/authentication/user/login")
    fun getLoginResponse(@Field("email") email: String,
                         @Field("password") password: String) : Call<LoginResponse>

    @FormUrlEncoded
    @POST("register")
    fun getRegisterResponse(@Field("first_name") fName: String,@Field("last_name") LName: String,@Field("email") email: String,
                            @Field("mobile_number") mobile: String,
                         @Field("password") password: String,
                         @Field("c_password") Cpassword: String,
                         @Field("role") role: String,
                         @Field("about") about: String,
                         @Field("city") city: String,
                         @Field("service_therapist_provider") provider: String,
                         @Field("therapist_focus") focus: String,
                         @Field("type_of_doctor") doctor: String,
                         @Field("status_id") status: Int,@Field("introduction") introduction: String,@Field("education") education: String,) : Call<String>

    @FormUrlEncoded
    @POST("package")
    fun createSpecialOffer(@Header("Authorization") header: String,@Field("number_of_sessions") number: Int,@Field("price") price: String) : Call<String>    @FormUrlEncoded

    @POST("bank")
    fun createBankDetail(@Header("Authorization") header: String,@Field("bank_name") name: String,@Field("branch_name") branchName: String,@Field("account_number") accountNumber: String,@Field("account_title") accountTitle: String,@Field("iban") iban: String) : Call<String>

}