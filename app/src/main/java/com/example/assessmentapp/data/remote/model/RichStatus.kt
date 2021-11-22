package com.example.assessmentapp.data.remote.model

import com.google.gson.annotations.SerializedName

   
data class RichStatus (

   @SerializedName("entities") var entities : List<String>,
   @SerializedName("text") var text : String

)