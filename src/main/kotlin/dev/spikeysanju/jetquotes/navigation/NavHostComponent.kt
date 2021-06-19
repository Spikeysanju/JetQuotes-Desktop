package dev.spikeysanju.jetquotes.navigation

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.extensions.compose.jetbrains.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.animation.child.crossfadeScale
import com.arkivanov.decompose.replaceCurrent
import com.arkivanov.decompose.router
import dev.spikeysanju.jetquotes.view.quotes.QuotesScreenComponent
import dev.spikeysanju.jetquotes.view.splash.SplashScreenComponent

class NavHostComponent(private val componentContext: ComponentContext) : Component,
    ComponentContext by componentContext {


    /**
     * Configure Initial Router Engine
     */
    private val router = router<Screen, Component>(
        initialConfiguration = Screen.Splash,
        childFactory = ::createScreenComponent
    )


    /**
     * When navigation request defined it will be redirected to specific screen below
     */
    private fun createScreenComponent(screen: Screen, componentContext: ComponentContext): Component {
        return when (screen) {
            is Screen.Splash -> SplashScreenComponent(
                componentContext = componentContext,
                onSplashFinished = ::onSplashFinished,
            )
            Screen.Quotes -> QuotesScreenComponent(
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