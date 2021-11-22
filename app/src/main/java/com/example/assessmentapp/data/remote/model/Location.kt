package com.example.assessmentapp.data.remote.model

import com.google.gson.annotations.SerializedName

   
data class Location (

   @SerializedName("address") var address : String,
   @SerializedName("crossStreet") var crossStreet : String,
   @SerializedName("lat") var lat : Double,
   @SerializedName("lng") var lng : Double,
   @SerializedName("labeledLatLngs") var labeledLatLngs : List<LabeledLatLngs>,
   @SerializedName("postalCode") var postalCode : String,
   @SerializedName("cc") var cc : String,
   @SerializedName("city") var city : String,
   @SerializedName("state") var state : String,
   @SerializedName("country") var country : String,
   @SerializedName("formattedAddress") var formattedAddress : List<String>

)