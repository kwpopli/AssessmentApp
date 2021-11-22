package com.example.assessmentapp.data.local.db

import com.example.assessmentapp.data.local.dao.VenueDetailsDao
import com.example.assessmentapp.data.local.dao.VenueListDao

interface IAppDatabase {
    fun getVenueDetailsDao(): VenueDetailsDao
    fun getVenueListDao(): VenueListDao
}