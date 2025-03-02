package com.example.tp2part2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class CountryDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country_detail)

        // Get the selected country from the intent
        @Suppress("DEPRECATION")
        val selectedCountry: Country? = intent.getParcelableExtra("COUNTRY")



        // Check if the country is not null
        selectedCountry?.let { country ->
            // Find the views in the layout
            val nameTextView: TextView = findViewById(R.id.detailCountryNameTextView)
            val capitalTextView: TextView = findViewById(R.id.detailCountryCapitalTextView)
            val regionTextView: TextView = findViewById(R.id.detailCountryRegionTextView)
            val flagImageView: ImageView = findViewById(R.id.detailCountryFlagImageView)

            // Set the data to the views
            nameTextView.text = country.name
            capitalTextView.text = "Capital: ${country.capital}"
            regionTextView.text = "Region: ${country.region}"
            Picasso.get().load(country.flagUrl).into(flagImageView)
        }
    }
}