package com.example.assessmentapp.ui.model

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "venue_list", primaryKeys = ["venue_id", "near_by"])
data class VenueListModel (
    @ColumnInfo(name = "venue_id") val venueId: String,
    @ColumnInfo(name = "venue_name")val venueName: String,
    @ColumnInfo(name = "venue_address")val venueAddress: String,
    @ColumnInfo(name = "near_by")val nearBy: String
)