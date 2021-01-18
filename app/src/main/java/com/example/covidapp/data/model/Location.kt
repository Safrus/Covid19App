package com.example.covidapp.data.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Location(
    @SerializedName("country")
    val country: String,
    @SerializedName("country_code")
    val countryCode: String,
    @SerializedName("country_population")
    val countryPopulation: Int,
    @SerializedName("county")
    val county: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("last_updated")
    val lastUpdated: String,
    @SerializedName("latest")
    val latest: Latest,
    @SerializedName("province")
    val province: String
) : Parcelable