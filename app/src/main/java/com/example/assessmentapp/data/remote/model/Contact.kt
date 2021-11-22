package com.example.assessmentapp.data.remote.model

import com.google.gson.annotations.SerializedName

   
data class Contact (

   @SerializedName("phone") var phone : String,
   @SerializedName("formattedPhone") var formattedPhone : String,
   @SerializedName("twitter") var twitter : String,
   @SerializedName("instagram") var instagram : String,
   @SerializedName("facebook") var facebook : String,
   @SerializedName("facebookUsername") var facebookUsername : String,
   @SerializedName("facebookName") var facebookName : String

)