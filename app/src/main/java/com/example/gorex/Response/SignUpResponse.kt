package com.example.gorex.Response

import android.provider.ContactsContract

data class SignUpResponse(var status : Int,var message : String,var data : ArrayList<String>)