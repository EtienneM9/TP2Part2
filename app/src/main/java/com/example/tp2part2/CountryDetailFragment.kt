package com.example.tp2part2
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.squareup.picasso.Picasso

class CountryDetailFragment : BottomSheetDialogFragment() {

    companion object {
        private const val ARG_COUNTRY = "country"

        fun newInstance(country: Country): CountryDetailFragment {
            val fragment = CountryDetailFragment()
            val args = Bundle()
            args.putParcelable(ARG_COUNTRY, country)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_country_detail, container, false)

        // Get the selected country from the arguments
        val selectedCountry = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            arguments?.getParcelable(ARG_COUNTRY, Country::class.java)
        } else {
            arguments?.getParcelable(ARG_COUNTRY)
        }

        // Check if the country is not null
        selectedCountry?.let { country ->
            // Find the views in the layout
            val nameTextView: TextView = view.findViewById(R.id.detailCountryNameTextView)
            val capitalTextView: TextView = view.findViewById(R.id.detailCountryCapitalTextView)
            val regionTextView: TextView = view.findViewById(R.id.detailCountryRegionTextView)
            val flagImageView: ImageView = view.findViewById(R.id.detailCountryFlagImageView)

            // Set the data to the views
            nameTextView.text = country.name
            capitalTextView.text = "Capital: ${country.capital}"
            regionTextView.text = "Region: ${country.region}"
            Picasso.get().load(country.flagUrl).into(flagImageView)
        }

        return view
    }
}