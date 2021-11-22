package com.example.assessmentapp.data.remote.model

import com.google.gson.annotations.SerializedName

   
data class Lists (

   @SerializedName("groups") var groups : List<Groups>

)