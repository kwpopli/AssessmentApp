package com.example.assessmentapp.data.remote.model

import com.google.gson.annotations.SerializedName

   
data class DefaultHours (

   @SerializedName("status") var status : String,
   @SerializedName("richStatus") var richStatus : RichStatus,
   @SerializedName("isOpen") var isOpen : Boolean,
   @SerializedName("isLocalHoliday") var isLocalHoliday : Boolean,
   @SerializedName("dayData") var dayData : List<String>,
   @SerializedName("timeframes") var timeframes : List<Timeframes>

)