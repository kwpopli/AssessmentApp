package com.example.assessmentapp.data.remote.model

import com.google.gson.annotations.SerializedName

   
data class Meta (

   @SerializedName("code") var code : Int,
   @SerializedName("requestId") var requestId : String

)