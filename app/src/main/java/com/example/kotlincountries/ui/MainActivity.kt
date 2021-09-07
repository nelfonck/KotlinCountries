package com.example.kotlincountries.ui

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlincountries.R
import com.example.kotlincountries.adapters.CountryAdapter
import com.example.kotlincountries.model.CountryModel
import com.example.kotlincountries.viewmodel.MainActivityViewModel

class MainActivity : AppCompatActivity() {
    private var countryAdapter: CountryAdapter? = null

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rvCountries: RecyclerView = findViewById(R.id.rvCountries)

        rvCountries.setHasFixedSize(true)
        rvCountries.layoutManager = GridLayoutManager(this,2)

        val mainActivityViewModel : MainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
        mainActivityViewModel.init(this)

        countryAdapter = CountryAdapter(this)
        countryAdapter!!.setData(ArrayList())

        rvCountries.adapter = countryAdapter

        mainActivityViewModel.getAllCountryList()
            ?.observe(this,  { countryList ->
                countryAdapter?.setData(countryList)
                countryAdapter?.notifyDataSetChanged()
            })
    }
}