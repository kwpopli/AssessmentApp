package com.example.assessmentapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.assessmentapp.ui.model.VenueDetailsModel

@Dao
interface VenueDetailsDao {
    @Query("SELECT * FROM venue_details_table WHERE id = :id")
    suspend fun getVenueDetailsById(id: String): List<VenueDetailsModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertVenueDetails(venueDetailsEntity: VenueDetailsModel)

}