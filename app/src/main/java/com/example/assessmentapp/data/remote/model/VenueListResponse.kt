package com.example.assessmentapp.data.remote.model

import com.google.gson.annotations.SerializedName


data class VenueListResponse (

        @SerializedName("meta") var meta : Meta,
        @SerializedName("response") var response : ResponseClass?

)


data class VenuePage (

        @SerializedName("id") var id : String

)

data class Venues (

        @SerializedName("id") var id : String,
        @SerializedName("name") var name : String,
        @SerializedName("location") var location : Location,
        @SerializedName("categories") var categories : List<Categories>,
        @SerializedName("venuePage") var venuePage : VenuePage

)

data class ResponseClass (

        @SerializedName("venues") var venues : List<Venues>

)