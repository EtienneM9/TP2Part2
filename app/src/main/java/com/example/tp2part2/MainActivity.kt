package com.example.tp2part2

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private var isFragmentVisible = false
    private val countryListFragment = CountryListFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val countryListButton: Button = findViewById(R.id.countryListButton)
        val fragmentButton: Button = findViewById(R.id.fragmentButton)

        countryListButton.setOnClickListener {
            val intent = Intent(this, CountryListActivity::class.java)
            startActivity(intent)
        }

        fragmentButton.setOnClickListener {
                // Open the fragment
                countryListFragment.show(supportFragmentManager, "CountryListBottomSheetFragment")
        }
    }
}
