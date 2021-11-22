package com.example.assessmentapp.data.remote.model

import com.google.gson.annotations.SerializedName

   
data class Menu (

   @SerializedName("type") var type : String,
   @SerializedName("label") var label : String,
   @SerializedName("anchor") var anchor : String,
   @SerializedName("url") var url : String,
   @SerializedName("mobileUrl") var mobileUrl : String,
   @SerializedName("externalUrl") var externalUrl : String

)