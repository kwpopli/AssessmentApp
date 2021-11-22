package com.example.assessmentapp.data.remote.model

import com.google.gson.annotations.SerializedName

   
data class BeenHere (

   @SerializedName("count") var count : Int,
   @SerializedName("unconfirmedCount") var unconfirmedCount : Int,
   @SerializedName("marked") var marked : Boolean,
   @SerializedName("lastCheckinExpiredAt") var lastCheckinExpiredAt : Int

)