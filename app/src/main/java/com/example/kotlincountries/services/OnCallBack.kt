package com.example.kotlincountries.services

import com.example.kotlincountries.model.CountryModel

interface OnCallBack {
    fun onSuccess(lista: List<CountryModel?>?)
    fun onError(error: String?)
}