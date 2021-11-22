package com.example.assessmentapp.data.remote.model

import com.google.gson.annotations.SerializedName

   
data class Attributes (

   @SerializedName("groups") var groups : List<Groups>

)