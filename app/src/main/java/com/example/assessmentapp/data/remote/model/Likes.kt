package com.example.assessmentapp.data.remote.model

import com.google.gson.annotations.SerializedName

   
data class Likes (

   @SerializedName("count") var count : Int,
   @SerializedName("groups") var groups : List<Groups>,
   @SerializedName("summary") var summary : String

)