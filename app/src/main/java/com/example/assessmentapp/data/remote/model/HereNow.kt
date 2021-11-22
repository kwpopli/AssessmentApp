package com.example.assessmentapp.data.remote.model

import com.google.gson.annotations.SerializedName

   
data class HereNow (

   @SerializedName("count") var count : Int,
   @SerializedName("summary") var summary : String,
   @SerializedName("groups") var groups : List<String>

)