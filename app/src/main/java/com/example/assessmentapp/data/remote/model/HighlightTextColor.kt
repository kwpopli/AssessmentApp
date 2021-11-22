package com.example.assessmentapp.data.remote.model

import com.google.gson.annotations.SerializedName

   
data class HighlightTextColor (

   @SerializedName("photoId") var photoId : String,
   @SerializedName("value") var value : Int

)