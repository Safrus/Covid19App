package com.example.covidapp.data.model


import com.google.gson.annotations.SerializedName

data class CountriesInfo(
    @SerializedName("latest")
    val latest: Latest,
    @SerializedName("locations")
    val locations: List<Location>
)