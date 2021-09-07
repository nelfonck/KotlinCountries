package com.example.kotlincountries.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.kotlincountries.model.CountryModel

@Database(entities = [CountryModel::class],version = 1, exportSchema = false)
abstract  class CountryDataBase : RoomDatabase() {

    abstract fun CountryDao() : CountryDao

    companion object {
        private var INSTANCE: CountryDataBase? = null

        fun getDataBase(context: Context): CountryDataBase? {

            if (INSTANCE == null){
                INSTANCE = Room.databaseBuilder(
                    context, CountryDataBase::class.java, "country_db"
                ).build()

            }
            return INSTANCE

        }


    }
}