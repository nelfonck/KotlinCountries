package com.example.kotlincountries.services

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.kotlincountries.model.CountryModel
import com.google.gson.Gson
import java.nio.charset.StandardCharsets
import java.util.*

class RemoteData {

    companion object{
        private const val BASE_URL = "https://restcountries.eu/rest/v2"

        @RequiresApi(Build.VERSION_CODES.KITKAT)
        fun getCountriesFromApi(context: Context, callBack: OnCallBack){
            val request = StringRequest(
                Request.Method.GET, BASE_URL,
                { response ->
                    val gson = Gson()
                    val allList: List<CountryModel> = listOf(
                        *gson.fromJson<Array<CountryModel>>(
                            response,
                            Array<CountryModel>::class.java
                        )
                    )
                    callBack.onSuccess(allList)
                }
            ) { error ->
                callBack.onError(
                 error.message
                )
            }

            val queue = Volley.newRequestQueue(context)
            queue.add(request)
        }
    }
}