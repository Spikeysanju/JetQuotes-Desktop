package dev.spikeysanju.jetquotes.view.splash

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import com.arkivanov.decompose.ComponentContext
import dev.spikeysanju.jetquotes.di.AppComponent
import dev.spikeysanju.jetquotes.navigation.Component
import dev.spikeysanju.jetquotes.viewmodel.MainViewModel
import javax.inject.Inject


class SplashScreenComponent(
    appComponent: AppComponent,
    componentContext: ComponentContext,
    private val onSplashFinished: () -> Unit
) : Component, ComponentContext by componentContext {
    @Inject
    lateinit var viewModel: MainViewModel

    init {
        appComponent.inject(this)
    }

    @Composable
    override fun render() {
        val scope = rememberCoroutineScope()

        LaunchedEffect(viewModel) {
            viewModel.init(scope)
            viewModel.startSplashScreen()
        }

        SplashScreen(viewModel, onSplashFinished = onSplashFinished)
    }
}