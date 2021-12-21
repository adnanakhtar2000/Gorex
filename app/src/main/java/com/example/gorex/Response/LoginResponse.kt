package com.example.gorex.Response

import android.provider.ContactsContract

data class LoginResponse(var status : Int,var message : String,var data : ArrayList<Data>)
data class Data(var token: String)