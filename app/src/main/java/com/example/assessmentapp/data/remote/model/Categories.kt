package com.example.assessmentapp.data.remote.model

import com.google.gson.annotations.SerializedName

   
data class Categories (

   @SerializedName("id") var id : String,
   @SerializedName("name") var name : String,
   @SerializedName("pluralName") var pluralName : String,
   @SerializedName("shortName") var shortName : String,
   @SerializedName("icon") var icon : Icon,
   @SerializedName("primary") var primary : Boolean

)