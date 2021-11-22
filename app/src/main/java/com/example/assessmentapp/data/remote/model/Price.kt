package com.example.assessmentapp.data.remote.model

import com.google.gson.annotations.SerializedName

   
data class Price (

   @SerializedName("tier") var tier : Int,
   @SerializedName("message") var message : String,
   @SerializedName("currency") var currency : String

)