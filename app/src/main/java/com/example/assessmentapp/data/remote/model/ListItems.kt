package com.example.assessmentapp.data.remote.model

import com.google.gson.annotations.SerializedName

   
data class ListItems (

   @SerializedName("count") var count : Int,
   @SerializedName("items") var items : List<Items>

)