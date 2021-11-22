package com.example.assessmentapp.ui.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "venue_details_table")
data class VenueDetailsModel (
    @PrimaryKey @ColumnInfo(name = "id") val venueId: String,
    @ColumnInfo(name = "venue_name") val venueName: String,
    @ColumnInfo(name = "venue_address") val venueAddress: String,
    @ColumnInfo(name = "venue_description")val venueDescription: String,
    @ColumnInfo(name = "venue_rating") val venueRating: String,
    @ColumnInfo(name = "venue_contact")val venueContact: String,
    @ColumnInfo(name = "venue_image_url")val venueImageUrl: String
)