package com.example.assessmentapp.data.remote.model

import com.google.gson.annotations.SerializedName

   
data class Venue (

   @SerializedName("id") var id : String,
   @SerializedName("name") var name : String,
   @SerializedName("contact") var contact : Contact,
   @SerializedName("location") var location : Location,
   @SerializedName("canonicalUrl") var canonicalUrl : String,
   @SerializedName("categories") var categories : List<Categories>,
   @SerializedName("verified") var verified : Boolean,
   @SerializedName("stats") var stats : Stats,
   @SerializedName("url") var url : String,
   @SerializedName("price") var price : Price,
   @SerializedName("likes") var likes : Likes,
   @SerializedName("dislike") var dislike : Boolean,
   @SerializedName("ok") var ok : Boolean,
   @SerializedName("rating") var rating : Double,
   @SerializedName("ratingSignals") var ratingSignals : Int,
   @SerializedName("menu") var menu : Menu,
   @SerializedName("allowMenuUrlEdit") var allowMenuUrlEdit : Boolean,
   @SerializedName("beenHere") var beenHere : BeenHere,
   @SerializedName("specials") var specials : Specials,
   @SerializedName("photos") var photos : Photos,
   @SerializedName("reasons") var reasons : Reasons,
   @SerializedName("description") var description : String,
   @SerializedName("storeId") var storeId : String,
   @SerializedName("page") var page : Page,
   @SerializedName("hereNow") var hereNow : HereNow,
   @SerializedName("createdAt") var createdAt : Int,
   @SerializedName("tips") var tips : Tips,
   @SerializedName("shortUrl") var shortUrl : String,
   @SerializedName("timeZone") var timeZone : String,
   @SerializedName("listed") var listed : Listed,
   @SerializedName("hours") var hours : Hours,
   @SerializedName("popular") var popular : Popular,
   @SerializedName("seasonalHours") var seasonalHours : List<String>,
   @SerializedName("defaultHours") var defaultHours : DefaultHours,
   @SerializedName("pageUpdates") var pageUpdates : PageUpdates,
   @SerializedName("inbox") var inbox : Inbox,
   @SerializedName("venueChains") var venueChains : List<String>,
   @SerializedName("attributes") var attributes : Attributes,
   @SerializedName("bestPhoto") var bestPhoto : BestPhoto,
   @SerializedName("colors") var colors : Colors

)