package com.example.covidapp.data.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Latest(
    @SerializedName("confirmed")
    val confirmed: Int,
    @SerializedName("deaths")
    val deaths: Int,
    @SerializedName("recovered")
    val recovered: Int
) : Parcelable