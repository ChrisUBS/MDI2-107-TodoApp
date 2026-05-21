package com.example.mdi2_107_todoapp

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import androidx.compose.runtime.mutableStateListOf

@SuppressLint("StaticFieldLeak")
object AppState {
    private var activityContext: Context? = null
    private val leakedActivity = mutableStateListOf<Context>()

    fun initialize(context: Context) {
        activityContext = context.applicationContext
        // activityContext = context // stores the activity directly
        // leakedActivity.add(context) // accumulates every leaked activity

        // Log.w("AppState", "Context stored -- leacked activities: ${leakedActivity.size}")
        Log.d("AppState", "Safe context stored - Application context never leaks")
    }
}