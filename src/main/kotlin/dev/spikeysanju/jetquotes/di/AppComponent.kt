package dev.spikeysanju.jetquotes.di

import dagger.Component
import dev.spikeysanju.jetquotes.view.quotes.QuotesScreenComponent
import dev.spikeysanju.jetquotes.view.splash.SplashScreenComponent
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        PreferenceModule::class
    ]
)


interface AppComponent {
    fun inject(splashScreenComponent: SplashScreenComponent)
    fun inject(quotesScreen: QuotesScreenComponent)
}