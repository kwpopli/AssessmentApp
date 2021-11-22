package com.example.assessmentapp.data.remote.model

import com.google.gson.annotations.SerializedName

   
data class PageInfo (

   @SerializedName("description") var description : String,
   @SerializedName("banner") var banner : String,
   @SerializedName("links") var links : Links

)