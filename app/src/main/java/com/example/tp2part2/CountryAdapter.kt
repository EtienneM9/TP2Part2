package com.example.tp2part2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class CountryAdapter(
    private val countries: List<Country>,
    private val onItemClick: (Country) -> Unit
) : RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {

    class CountryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.countryNameTextView)
        val flagImageView: ImageView = itemView.findViewById(R.id.countryFlagImageView)

        fun bind(country: Country, onItemClick: (Country) -> Unit) {
            itemView.setOnClickListener { onItemClick(country) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.country_item, parent, false)
        return CountryViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val currentCountry = countries[position]
        holder.nameTextView.text = currentCountry.name
        Picasso.get().load(currentCountry.flagUrl).into(holder.flagImageView)
        holder.bind(currentCountry, onItemClick)
    }

    override fun getItemCount(): Int {
        return countries.size
    }
}