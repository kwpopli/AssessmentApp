package com.example.assessmentapp.data.repository

import com.example.assessmentapp.BuildConfig
import com.example.assessmentapp.data.local.db.IAppDatabase
import com.example.assessmentapp.data.remote.Constants
import com.example.assessmentapp.data.remote.RetrofitService
import com.example.assessmentapp.data.remote.model.VenueDetailsResponse
import com.example.assessmentapp.data.remote.model.VenueListResponse
import com.example.assessmentapp.ui.model.VenueDetailsModel
import com.example.assessmentapp.ui.model.VenueListModel
import com.example.assessmentapp.util.IMyDispatchers
import kotlinx.coroutines.withContext

class VenueListRepository constructor(private val retrofitService: RetrofitService, private val myDispatchers: IMyDispatchers, private val appDatabase: IAppDatabase?) : IVenueListRepository {

    override suspend fun getVenueList(nearPlace: String): List<VenueListModel>? =
            withContext(myDispatchers.IO) {
                val venueList = getVenueListFromApi(nearPlace)
                if (!venueList.isNullOrEmpty()) {
                    appDatabase?.getVenueListDao()?.insertVenue(venueList)
                    venueList as ArrayList<VenueListModel>?
                } else {
                    appDatabase?.getVenueListDao()?.getVenueNearBy(nearPlace)
                }
            }

    private suspend fun getVenueListFromApi(nearPlace: String): List<VenueListModel>? =
            withContext(myDispatchers.IO) {
                try {
                    val call = retrofitService.getVenueList(
                            nearPlace,
                            Constants.RADIUS,
                            Constants.LIMIT,
                            Constants.VERSION,
                            BuildConfig.CLIENT_ID,
                            BuildConfig.CLIENT_SECRET
                    )
                    call.body()?.let {
                        processVenueListResponse(nearPlace, it)
                    }
                } catch (e: Exception) {
                    null
                }
            }

    private suspend fun processVenueListResponse(nearPlace: String, venueListResponse: VenueListResponse): List<VenueListModel> = withContext(myDispatchers.IO) {
        val venueList = ArrayList<VenueListModel>()
        venueListResponse.response?.venues?.let { safeVenues ->
            for (venue in safeVenues) {
                val venueListModel = VenueListModel(
                        venue.id,
                        venue.name,
                        venue.location.formattedAddress.toString().replace("[", "").replace("]", ""),
                        nearPlace
                )

                venueList.add(venueListModel)
            }
        }
        venueList
    }

    override suspend fun getVenueDetails(venueId: String): VenueDetailsModel? = withContext(myDispatchers.IO) {
        val venueDetailsModel = getVenueDetailsFromApi(venueId)
        venueDetailsModel?.let {
            appDatabase?.getVenueDetailsDao()?.insertVenueDetails(venueDetailsModel)
            venueDetailsModel
        } ?: kotlin.run {
            appDatabase?.getVenueDetailsDao()?.getVenueDetailsById(venueId)?.get(0)
        }
    }

    private suspend fun getVenueDetailsFromApi(venueId: String): VenueDetailsModel? = withContext(myDispatchers.IO) {
        try {
            val call = retrofitService.getVenueDetails(
                    venueId,
                    Constants.VERSION,
                    BuildConfig.CLIENT_ID,
                    BuildConfig.CLIENT_SECRET
            )
            call.body()?.let {
                processVenueDetailsResponse(it)
            }
        } catch (e: Exception) {
            null
        }
    }

    private suspend fun processVenueDetailsResponse(venueDetailsResponse: VenueDetailsResponse): VenueDetailsModel = withContext(myDispatchers.IO) {
        VenueDetailsModel(
                venueDetailsResponse.response?.venue?.id.orEmpty(),
                venueDetailsResponse.response?.venue?.name.orEmpty(),
                venueDetailsResponse.response?.venue?.location?.formattedAddress.toString()
                        .replace("[", "").replace("]", ""),
                venueDetailsResponse.response?.venue?.description.orEmpty(),
                venueDetailsResponse.response?.venue?.rating.toString(),
                venueDetailsResponse.response?.venue?.contact?.formattedPhone.orEmpty(),
                venueDetailsResponse.response?.venue?.bestPhoto?.prefix
                        + venueDetailsResponse.response?.venue?.bestPhoto?.width
                        + "x"
                        + venueDetailsResponse.response?.venue?.bestPhoto?.height
                        + venueDetailsResponse.response?.venue?.bestPhoto?.suffix
        )
    }


}