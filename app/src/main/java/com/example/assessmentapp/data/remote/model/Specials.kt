package com.example.assessmentapp.data.remote.model

import com.google.gson.annotations.SerializedName

   
data class Specials (

   @SerializedName("count") var count : Int,
   @SerializedName("items") var items : List<String>

)