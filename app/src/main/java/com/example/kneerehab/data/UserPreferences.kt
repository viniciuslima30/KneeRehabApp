
package com.example.kneerehab.data

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore by preferencesDataStore(
    name = "user_preferences"
)

class UserPreferences(private val context: Context) {

    companion object {
        val REMINDERS_ENABLED = booleanPreferencesKey("reminders_enabled")
    }

    val remindersEnabled: Flow<Boolean> =
        context.dataStore.data.map { preferences ->
            preferences[REMINDERS_ENABLED] ?: false
        }

    suspend fun setRemindersEnabled(enabled: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[REMINDERS_ENABLED] = enabled
        }
    }
}
