package com.projects.mvvm.utils

import android.content.Context
import android.net.ConnectivityManager
import java.util.*

class NetworkUtils(private val context: Context) {

    fun isOnline(): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val netInfo = Objects.requireNonNull(cm).activeNetworkInfo
        return netInfo != null && netInfo.isConnectedOrConnecting
    }
}