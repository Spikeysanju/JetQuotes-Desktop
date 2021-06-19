package dev.spikeysanju.jetquotes.repo

import java.util.prefs.Preferences
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UIModeRepo @Inject constructor(private val pref: Preferences) {

    fun storeUIMode(isDarkTheme: Boolean) {
        pref.putBoolean(UI_MODE_KEY, isDarkTheme)
    }

    fun getUIMode(): Boolean = pref.getBoolean(UI_MODE_KEY, false)

    fun getTheme(): Boolean {
        return pref.addPreferenceChangeListener {
            it.newValue
        }.toString().toBoolean()
    }

    companion object {
        private const val UI_MODE_KEY = "isDarkTheme"
    }
}