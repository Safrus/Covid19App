package com.example.covidapp.data.api

import androidx.annotation.WorkerThread
import com.example.covidapp.data.model.CountriesInfo
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CovidApi {

    @WorkerThread
    @GET("v2/locations")
    suspend fun getCountriesInfo(
        @Query("source") source: String,
        //@Query("country_code") countryCode: String,
        //@Query("timelines") timeLines: Int,
    ): Response<CountriesInfo>

}