package com.example.assessmentapp.data.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.assessmentapp.data.remote.Constants
import com.example.assessmentapp.data.local.dao.VenueDetailsDao
import com.example.assessmentapp.data.local.dao.VenueListDao
import com.example.assessmentapp.ui.model.VenueDetailsModel
import com.example.assessmentapp.ui.model.VenueListModel

@Database(
    entities = [VenueListModel::class, VenueDetailsModel::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase(), IAppDatabase{

    abstract override fun getVenueDetailsDao(): VenueDetailsDao
    abstract override fun getVenueListDao(): VenueListDao

    companion object {
        private var appDatabase: AppDatabase? = null
        fun getInstance(context: Context): AppDatabase? {
            if (appDatabase == null) {
                appDatabase = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java, Constants.DATABASE_NAME
                    ).build()
            }
            return appDatabase
        }
    }
}
