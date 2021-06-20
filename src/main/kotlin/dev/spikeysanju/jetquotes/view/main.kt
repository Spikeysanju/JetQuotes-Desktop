package dev.spikeysanju.jetquotes.view

import androidx.compose.desktop.Window
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.jetbrains.rememberRootComponent
import dev.spikeysanju.jetquotes.navigation.NavHostComponent
import dev.spikeysanju.jetquotes.ui.JetQuotesTheme
import dev.spikeysanju.jetquotes.ui.R
import dev.spikeysanju.jetquotes.viewmodel.MainViewModel
import java.awt.image.BufferedImage
import javax.imageio.ImageIO

fun main() = Window(title = R.string.APP_NAME, resizable = true, icon = getAppIcon()) {

    val darkTheme = remember { mutableStateOf(false) }
    JetQuotesTheme(darkTheme = darkTheme.value) {
        Box(modifier = Modifier.fillMaxSize().background(MaterialTheme.colors.primary)) {
            rememberRootComponent(factory = ::NavHostComponent)
                .render()
        }
    }
}

private fun getAppIcon(): BufferedImage {
    return ImageIO.read(MainViewModel::class.java.classLoader.getResourceAsStream("drawable/ic_jetquotes_logo.png"))
}
