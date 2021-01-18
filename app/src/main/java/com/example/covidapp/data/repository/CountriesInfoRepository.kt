package com.example.covidapp.data.repository

import kotlinx.coroutines.flow.Flow

interface CountriesInfoRepository {
    fun getCountriesInfo(source: String): Flow<Any?>
    suspend fun getCountriesInfoFromApi(source: String): Any?
}