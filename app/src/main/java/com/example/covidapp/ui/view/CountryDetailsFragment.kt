package com.example.covidapp.ui.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.covidapp.R
import com.example.covidapp.data.model.Location

class CountryDetailsFragment : Fragment(R.layout.country_details_fragment) {

    private lateinit var location: Location
    private lateinit var countryCodeTextView: TextView
    private lateinit var countryTextView: TextView
    private lateinit var provincyTextView: TextView
    private lateinit var populationTextView: TextView
    private lateinit var lastUpdatedTextView: TextView
    private lateinit var confirmedTextView: TextView
    private lateinit var deathsTextView: TextView
    private lateinit var recoveredTextView: TextView

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        countryCodeTextView = view.findViewById(R.id.countryCodeTextView)
        countryTextView = view.findViewById(R.id.counterTextView)
        provincyTextView = view.findViewById(R.id.provincyTextView)
        populationTextView = view.findViewById(R.id.populationTextView)
        lastUpdatedTextView = view.findViewById(R.id.lastUpdatedTextView)
        confirmedTextView = view.findViewById(R.id.confirmedTextView)
        deathsTextView = view.findViewById(R.id.deathsTextViiew)
        recoveredTextView = view.findViewById(R.id.recoveredTextView)
        if (arguments != null) {
            val args: CountryDetailsFragmentArgs =
                CountryDetailsFragmentArgs.fromBundle(requireArguments())
            location = args.location
        }
        countryCodeTextView.text = convertCountryCodeToEmoji(location.countryCode)
        countryTextView.text = "Country: " + location.country
        if (location.province != "") {
            provincyTextView.text = "Province: " + location.province
        } else {
            provincyTextView.text = "Province: No"
        }
        populationTextView.text = "Population: " + location.countryPopulation
        lastUpdatedTextView.text = "Last Updated: " + location.lastUpdated.take(19)
        confirmedTextView.text = "Confirmed: " + location.latest.confirmed
        deathsTextView.text = "Deaths: " + location.latest.deaths
        recoveredTextView.text = "Recovered: " + location.latest.recovered
    }

    private fun convertCountryCodeToEmoji(countryCode: String): String {
        val flagOffset = 0x1F1E6
        val asciiOffset = 0x41
        val firstChar = Character.codePointAt(countryCode, 0) - asciiOffset + flagOffset
        val secondChar = Character.codePointAt(countryCode, 1) - asciiOffset + flagOffset
        return (String(Character.toChars(firstChar))
                + String(Character.toChars(secondChar)))
    }
}