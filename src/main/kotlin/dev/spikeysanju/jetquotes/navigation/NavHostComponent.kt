package dev.spikeysanju.jetquotes.navigation

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.extensions.compose.jetbrains.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.animation.child.crossfadeScale
import com.arkivanov.decompose.replaceCurrent
import com.arkivanov.decompose.router
import dev.spikeysanju.jetquotes.di.AppComponent
import dev.spikeysanju.jetquotes.di.DaggerAppComponent
import dev.spikeysanju.jetquotes.view.quotes.QuotesScreenComponent
import dev.spikeysanju.jetquotes.view.splash.SplashScreenComponent

class NavHostComponent(private val componentContext: ComponentContext) : Component,
    ComponentContext by componentContext {

    private val appComponent: AppComponent = DaggerAppComponent.create()

    /**
     * Configure Router Engine
     */
    private val router = router<Screen, Component>(
        initialConfiguration = Screen.Splash,
        childFactory = ::createScreenComponent
    )


    /**
     * When a new navigation request made, the screen will be created by this method.
     */
    private fun createScreenComponent(screen: Screen, componentContext: ComponentContext): Component {
        return when (screen) {
            is Screen.Splash -> SplashScreenComponent(
                appComponent = appComponent,
                componentContext = componentContext,
                onSplashFinished = ::onSplashFinished,
            )
            Screen.Quotes -> QuotesScreenComponent(
                appComponent = appComponent,
                componentContext = componentContext,
                isDarkTheme = false
            )
        }
    }

    @OptIn(ExperimentalDecomposeApi::class)
    @Composable
    override fun render() {
        Children(
            routerState = router.state,
            animation = crossfadeScale()
        ) { child ->
            child.instance.render()
        }
    }

    /**
     * Replace after splash screen on finished
     */
    private fun onSplashFinished() {
        router.replaceCurrent(Screen.Quotes)
    }
}