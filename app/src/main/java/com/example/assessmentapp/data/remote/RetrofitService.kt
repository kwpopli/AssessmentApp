package com.example.assessmentapp.data.remote

import com.example.assessmentapp.BuildConfig
import com.example.assessmentapp.data.remote.model.VenueDetailsResponse
import com.example.assessmentapp.data.remote.model.VenueListResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitService {
    @GET("v2/venues/search")
    suspend fun getVenueList(@Query("near") near: String,
                     @Query("radius") radius: Int,
                     @Query("limit") limit: Int,
                     @Query("v") version: Int,
                     @Query("client_id") client_id: String,
                     @Query("client_secret") client_secret: String
    ): Response<VenueListResponse>

    @GET("v2/venues/{venue_id}")
    suspend fun getVenueDetails(@Path("venue_id") venueId: String,
                        @Query("v") version: Int,
                        @Query("client_id") client_id: String,
                        @Query("client_secret") client_secret: String
    ): Response<VenueDetailsResponse>

    companion object {

        private var retrofitService: RetrofitService? = null

        fun getInstance() : RetrofitService? {
            if (retrofitService == null) {
                val loggingInterceptor = HttpLoggingInterceptor()
                loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
                val okHttpClient = OkHttpClient.Builder().addInterceptor(loggingInterceptor).build()
                val retrofit = Retrofit.Builder()
                    .baseUrl(BuildConfig.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build()
                retrofitService = retrofit.create(RetrofitService::class.java)
            }
            return retrofitService
        }
    }
}