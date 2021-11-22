package com.example.assessmentapp.data.remote.model

import com.google.gson.annotations.SerializedName

   
data class Colors (

   @SerializedName("highlightColor") var highlightColor : HighlightColor,
   @SerializedName("highlightTextColor") var highlightTextColor : HighlightTextColor,
   @SerializedName("algoVersion") var algoVersion : Int

)