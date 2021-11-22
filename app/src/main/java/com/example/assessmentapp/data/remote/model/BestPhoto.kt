package com.example.assessmentapp.data.remote.model

import com.google.gson.annotations.SerializedName

   
data class BestPhoto (

   @SerializedName("id") var id : String,
   @SerializedName("createdAt") var createdAt : Int,
   @SerializedName("source") var source : Source,
   @SerializedName("prefix") var prefix : String,
   @SerializedName("suffix") var suffix : String,
   @SerializedName("width") var width : Int,
   @SerializedName("height") var height : Int,
   @SerializedName("visibility") var visibility : String

)