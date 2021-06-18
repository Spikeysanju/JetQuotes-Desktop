package dev.spikeysanju.jetquotes.ui

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import dev.spikeysanju.jetquotes.ui.R.color.activeDark
import dev.spikeysanju.jetquotes.ui.R.color.activeLight
import dev.spikeysanju.jetquotes.ui.R.color.black
import dev.spikeysanju.jetquotes.ui.R.color.paleBlack
import dev.spikeysanju.jetquotes.ui.R.color.paleWhite
import dev.spikeysanju.jetquotes.ui.R.color.white


private val DarkColorPalette = darkColors(
    primary = black,
    onPrimary = white,
    primaryVariant = paleBlack,
    onBackground = activeDark

)

private val LightColorPalette = lightColors(
    primary = white,
    onPrimary = black,
    primaryVariant = paleWhite,
    onBackground = activeLight
)

@Composable
fun JetQuotesTheme(darkTheme: Boolean = true, content: @Composable() () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = typography,
        content = content
    )
}