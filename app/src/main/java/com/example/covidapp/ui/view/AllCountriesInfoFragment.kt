package com.example.covidapp.ui.view

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.covidapp.R
import com.example.covidapp.data.model.Location
import com.example.covidapp.ui.adapter.CountriesInfoAdapter
import com.example.covidapp.ui.viewmodel.CountriesInfoViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class AllCountriesInfoFragment : Fragment(R.layout.all_countries_info_fragment),
    CountriesInfoAdapter.CountryClickListener {

    private lateinit var recyclerView: RecyclerView
    private val countriesInfoViewModel by viewModel<CountriesInfoViewModel>()
    private lateinit var countriesInfoAdapter: CountriesInfoAdapter
    private val observer = Observer<List<Location>> { handleResponse(it) }
    private lateinit var navController: NavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recyclerView)
        navController = Navigation.findNavController(view)
        initViews()
        countriesInfoViewModel.countriesInfoLiveData.observe(viewLifecycleOwner, observer)
        countriesInfoViewModel.getCountriesInfo()
    }

    private fun initViews() {
        countriesInfoAdapter = CountriesInfoAdapter(this)
        recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = countriesInfoAdapter
            recycledViewPool.clear()
        }
    }

    private fun handleResponse(it: List<Location>) {
        bindData(it)
    }

    private fun bindData(locations: List<Location>) {
        countriesInfoAdapter.submitList(locations)
    }

    override fun countryClick(position: Int, item: Location) {
        val action: AllCountriesInfoFragmentDirections.ActionAllCountriesInfoFragmentToCountryDetailsFragment =
            AllCountriesInfoFragmentDirections.actionAllCountriesInfoFragmentToCountryDetailsFragment(
                item
            )
        navController.navigate(action)
    }
}