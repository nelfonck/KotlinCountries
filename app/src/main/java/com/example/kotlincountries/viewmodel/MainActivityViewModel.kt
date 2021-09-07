package com.example.kotlincountries.viewmodel

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.kotlincountries.model.CountryModel
import com.example.kotlincountries.repository.CountryRepository

class MainActivityViewModel :ViewModel() {
    private var countryRepository: CountryRepository? =null

    fun init(context: Context){
        if (countryRepository == null){
            countryRepository = CountryRepository()
            countryRepository!!.init(context)
        }
    }

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    fun getAllCountryList() : LiveData<List<CountryModel>>? {
        return countryRepository?.getCountries()
    }

}