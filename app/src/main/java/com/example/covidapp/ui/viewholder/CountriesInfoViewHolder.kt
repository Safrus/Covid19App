package com.example.covidapp.ui.viewholder

import android.annotation.SuppressLint
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.covidapp.R
import com.example.covidapp.data.model.Location
import com.example.covidapp.ui.adapter.CountriesInfoAdapter

class CountriesInfoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val countryCodeTextView: TextView = itemView.findViewById(R.id.countryEmojiTextView)
    private val countryTextView: TextView = itemView.findViewById(R.id.countryTextView)
    private val provinceTextView: TextView = itemView.findViewById(R.id.provinceTextView)

    @SuppressLint("SetTextI18n")
    fun bindData(
        location: Location?,
        countryClickListener: CountriesInfoAdapter.CountryClickListener
    ) {
        location?.let {
            countryCodeTextView.text = convertCountryCodeToEmoji(it.countryCode)
            countryTextView.text = "Country: " + it.country
            if (it.province != "") {
                provinceTextView.text = "Province: " + it.province
            } else {
                provinceTextView.text = "Province: No"
            }
            itemView.setOnClickListener {
                countryClickListener.countryClick(adapterPosition, location)
            }
        }
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