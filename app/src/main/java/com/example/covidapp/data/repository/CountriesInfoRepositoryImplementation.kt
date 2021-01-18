package com.example.covidapp.data.repository

import com.example.covidapp.data.api.CovidApi
import kotlinx.coroutines.flow.flow

class CountriesInfoRepositoryImplementation(private val api: CovidApi) : CountriesInfoRepository {

    override fun getCountriesInfo(source: String) = flow {
        emit(getCountriesInfoFromApi(source))
    }

    override suspend fun getCountriesInfoFromApi(source: String) =
        api.getCountriesInfo(source)
            .run {
                if (isSuccessful && body() != null) {
                    return@run body()?.locations
                } else {
                    Error(

                    )
                }
            }

}