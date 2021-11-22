package com.example.assessmentapp.data.remote.model

import com.google.gson.annotations.SerializedName

   
data class VenueDetailsResponse (

   @SerializedName("meta") var meta : Meta,
   @SerializedName("response") var response : Response?

)