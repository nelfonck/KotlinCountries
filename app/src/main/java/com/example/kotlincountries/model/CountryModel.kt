package com.example.kotlincountries.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Countries")
class CountryModel {
    @PrimaryKey(autoGenerate = true)
    var id = 0

    @ColumnInfo(name = "name")
    var name: String? = null

    @ColumnInfo(name = "capital")
    var capital: String? = null

    @ColumnInfo(name = "population")
    var population: String? = null

    @ColumnInfo(name = "flag")
    var flag: String? = null

}