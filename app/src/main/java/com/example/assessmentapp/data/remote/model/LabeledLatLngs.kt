package com.example.assessmentapp.data.remote.model

import com.google.gson.annotations.SerializedName

   
data class LabeledLatLngs (

   @SerializedName("label") var label : String,
   @SerializedName("lat") var lat : Double,
   @SerializedName("lng") var lng : Double

)