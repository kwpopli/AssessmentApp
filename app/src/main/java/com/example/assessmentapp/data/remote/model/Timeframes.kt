package com.example.assessmentapp.data.remote.model

import com.google.gson.annotations.SerializedName

   
data class Timeframes (

   @SerializedName("days") var days : String,
   @SerializedName("includesToday") var includesToday : Boolean,
   @SerializedName("open") var open : List<Open>,
   @SerializedName("segments") var segments : List<String>

)