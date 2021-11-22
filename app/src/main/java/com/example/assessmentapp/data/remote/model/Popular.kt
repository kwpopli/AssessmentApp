package com.example.assessmentapp.data.remote.model

import com.google.gson.annotations.SerializedName

   
data class Popular (

   @SerializedName("isOpen") var isOpen : Boolean,
   @SerializedName("isLocalHoliday") var isLocalHoliday : Boolean,
   @SerializedName("timeframes") var timeframes : List<Timeframes>

)