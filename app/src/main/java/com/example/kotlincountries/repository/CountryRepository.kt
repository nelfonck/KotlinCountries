package com.example.kotlincountries.repository

import android.content.Context
import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import com.example.kotlincountries.db.CountryDao
import com.example.kotlincountries.db.CountryDataBase
import com.example.kotlincountries.model.CountryModel
import com.example.kotlincountries.network.NetworkStatus
import com.example.kotlincountries.services.OnCallBack
import com.example.kotlincountries.services.RemoteData


class CountryRepository {

        private var mContex: Context? = null
        private var countryDao: CountryDao? = null
        private var db: CountryDataBase? = null

        fun init(context: Context){
                mContex = context
                db = CountryDataBase.getDataBase(mContex!!)
                countryDao = db?.CountryDao()
        }

        @RequiresApi(Build.VERSION_CODES.KITKAT)
        fun getCountries() : LiveData<List<CountryModel>>? {
            if (mContex?.let { NetworkStatus.isNetworkConnected(it) } == true){
                apiCallAndPutInDb()
            }
            return countryDao?.getAllCountries()
        }


        @RequiresApi(Build.VERSION_CODES.KITKAT)
        private fun apiCallAndPutInDb() {

            mContex?.let {
                RemoteData.getCountriesFromApi(it, object : OnCallBack {
                    override fun onSuccess(lista: List<CountryModel?>?) {
                        Thread {
                            countryDao?.deleteAllCountries()
                            countryDao?.insertAllData(lista)
                        }.start()
                    }

                    override fun onError(error: String?) {
                        Toast.makeText(
                            mContex,
                            error,
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                })
            }

        }



}