package com.example.kotlincountries.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.kotlincountries.model.CountryModel

@Dao
interface CountryDao {

    @Query("SELECT * from Countries")
    fun getAllCountries(): LiveData<List<CountryModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllData(countryList: List<CountryModel?>?)

    @Query("DELETE  FROM Countries")
    fun deleteAllCountries()

}