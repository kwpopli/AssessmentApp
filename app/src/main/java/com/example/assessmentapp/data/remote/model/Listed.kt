package com.example.assessmentapp.data.remote.model

import com.google.gson.annotations.SerializedName

   
data class Listed (

   @SerializedName("count") var count : Int,
   @SerializedName("groups") var groups : List<Groups>

)