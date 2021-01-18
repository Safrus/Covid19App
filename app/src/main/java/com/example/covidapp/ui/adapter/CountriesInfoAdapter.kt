package com.example.covidapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.example.covidapp.R
import com.example.covidapp.data.model.Location
import com.example.covidapp.ui.viewholder.CountriesInfoViewHolder

class CountriesInfoAdapter(private val countryClickListener: CountryClickListener) :
    ListAdapter<Location, CountriesInfoViewHolder>(CountriesInfoDiffUtil) {
    private object CountriesInfoDiffUtil : DiffUtil.ItemCallback<Location>() {

        override fun areItemsTheSame(oldItem: Location, newItem: Location) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Location, newItem: Location) = oldItem == newItem
    }

    interface CountryClickListener {
        fun countryClick(position: Int, item: Location)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CountriesInfoViewHolder {
        return CountriesInfoViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.country_item, parent, false)
        )
    }

    override fun onBindViewHolder(
        holder: CountriesInfoViewHolder,
        position: Int
    ) {
        holder.bindData(getItem(position), countryClickListener)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }


}