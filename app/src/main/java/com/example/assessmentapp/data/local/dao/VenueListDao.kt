package com.example.assessmentapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.assessmentapp.ui.model.VenueListModel

@Dao
interface VenueListDao {
    @Query("SELECT * FROM venue_list WHERE near_by = :nearBy")
    suspend fun getVenueNearBy(nearBy: String): List<VenueListModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertVenue(venueDetailsEntity: List<VenueListModel>)

}