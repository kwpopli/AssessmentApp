package com.example.assessmentapp.data.remote.model

import com.google.gson.annotations.SerializedName

   
data class Items (

   @SerializedName("displayName") var displayName : String,
   @SerializedName("displayValue") var displayValue : String,
   @SerializedName("priceTier") var priceTier : Int

)