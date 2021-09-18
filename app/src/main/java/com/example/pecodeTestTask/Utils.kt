package com.example.pecodeTestTask

import android.content.Context

private const val SHARED_ID = "shared_name"
private const val COUNT_ID = "count_id"

fun saveFragmentsCount(context: Context, count: Int) {
    val sharedPreferences = context.getSharedPreferences(SHARED_ID, Context.MODE_PRIVATE)
    sharedPreferences
        .edit()
        .putInt(COUNT_ID, count)
        .apply()
}

fun getFragmentCount(context: Context): Int {
    val sharedPreferences = context.getSharedPreferences(SHARED_ID, Context.MODE_PRIVATE)
    return sharedPreferences.getInt(COUNT_ID, 1)
}