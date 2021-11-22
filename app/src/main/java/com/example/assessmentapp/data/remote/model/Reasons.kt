package com.example.assessmentapp.data.remote.model

import com.google.gson.annotations.SerializedName

   
data class Reasons (

   @SerializedName("count") var count : Int,
   @SerializedName("items") var items : List<Items>

)