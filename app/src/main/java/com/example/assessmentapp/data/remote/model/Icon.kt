package com.example.assessmentapp.data.remote.model

import com.google.gson.annotations.SerializedName

   
data class Icon (

   @SerializedName("prefix") var prefix : String,
   @SerializedName("suffix") var suffix : String

)