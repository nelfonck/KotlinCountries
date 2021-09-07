package com.example.kotlincountries.network

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

@Suppress("RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class NetworkStatus {

    companion object{
        fun isNetworkConnected(application: Context): Boolean {
            val connectivityManager =
                application.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            return connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).state == NetworkInfo.State.CONNECTED ||
                    connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).state == NetworkInfo.State.CONNECTED
        }
    }

}