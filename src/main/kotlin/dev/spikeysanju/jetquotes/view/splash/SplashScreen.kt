package dev.spikeysanju.jetquotes.view.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import dev.spikeysanju.jetquotes.components.PulseEffect
import dev.spikeysanju.jetquotes.ui.R
import dev.spikeysanju.jetquotes.viewmodel.MainViewModel

@Composable
fun SplashScreen(viewModel: MainViewModel, onSplashFinished: () -> Unit) {
    PulseEffect {
        val state = viewModel.splash.collectAsState().value
        if (state) {
            onSplashFinished()
            return@PulseEffect
        }
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Image(imageResource("drawable/ic_jetquotes_logo.png"), R.string.APP_LOGO, modifier = Modifier.size(100.dp))
        }
    }
}

