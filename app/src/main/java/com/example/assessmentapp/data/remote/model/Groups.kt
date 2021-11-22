package com.example.assessmentapp.data.remote.model

import com.google.gson.annotations.SerializedName

   
data class Groups (

   @SerializedName("type") var type : String,
   @SerializedName("name") var name : String,
   @SerializedName("summary") var summary : String,
   @SerializedName("count") var count : Int,
   @SerializedName("items") var items : List<Items>

)