package com.example.assessmentapp.data.remote.model

import com.google.gson.annotations.SerializedName

   
data class Stats (

   @SerializedName("tipCount") var tipCount : Int,
   @SerializedName("usersCount") var usersCount : Int,
   @SerializedName("checkinsCount") var checkinsCount : Int,
   @SerializedName("visitsCount") var visitsCount : Int

)