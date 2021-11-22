package com.example.assessmentapp.data.remote.model

import com.google.gson.annotations.SerializedName

   
data class User (

   @SerializedName("firstName") var firstName : String,
   @SerializedName("lastName") var lastName : String,
   @SerializedName("countryCode") var countryCode : String

)