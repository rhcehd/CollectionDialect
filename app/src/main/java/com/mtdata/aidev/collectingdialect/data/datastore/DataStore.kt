package com.mtdata.aidev.collectingdialect.data.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "preference")

const val KEY_COLLECTOR_ID = "collector_id"
const val KEY_COLLECTOR_BIRTH_YEAR = "collector_birth_year"

const val KEY_LAST_RECORD_TIME_MILLIS = "last_record"


const val TIME_24_HOUR_MILLIS = 60 * 60 * 1000