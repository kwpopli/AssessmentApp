package com.example.assessmentapp.data.remote.model

import com.google.gson.annotations.SerializedName

   
data class Page (

   @SerializedName("pageInfo") var pageInfo : PageInfo,
   @SerializedName("user") var user : User

)