package com.example.covidapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.covidapp.data.model.Location
import com.example.covidapp.data.repository.CountriesInfoRepositoryImplementation
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class CountriesInfoViewModel(private val countriesInfoRepositoryImplementation: CountriesInfoRepositoryImplementation) :
    ViewModel() {

    private val mutableCountriesInfoLiveData = MutableLiveData<List<Location>>()
    private var getCountriesInfoJob: Job? = null

    val countriesInfoLiveData: LiveData<List<Location>> = mutableCountriesInfoLiveData

    fun getCountriesInfo() {
        getCountriesInfoJob = viewModelScope.launch {
            countriesInfoRepositoryImplementation.getCountriesInfo("jhu").collect {
                mutableCountriesInfoLiveData.value = it as List<Location>?
            }
        }
    }
}