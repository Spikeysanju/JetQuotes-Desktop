package dev.spikeysanju.jetquotes.di

import dagger.Module
import dagger.Provides
import java.util.prefs.Preferences
import javax.inject.Singleton

@Module
class PreferenceModule {
    @Provides
    @Singleton
    fun providePreference(): Preferences {
        return Preferences.userRoot().node("JetQuotes")
    }
}