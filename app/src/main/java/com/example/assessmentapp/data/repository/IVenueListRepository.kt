package com.example.assessmentapp.data.repository

import com.example.assessmentapp.ui.model.VenueDetailsModel
import com.example.assessmentapp.ui.model.VenueListModel

interface IVenueListRepository {
    suspend fun getVenueList(nearPlace: String): List<VenueListModel>?
    suspend fun getVenueDetails(venueId: String): VenueDetailsModel?
}