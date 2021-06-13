package ui

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import ui.R.color.black
import ui.R.color.paleBlack
import ui.R.color.paleWhite
import ui.R.color.white


private val DarkColorPalette = darkColors(
    primary = black,
    onPrimary = white,
    primaryVariant = paleBlack

)

private val LightColorPalette = lightColors(
    primary = white,
    onPrimary = black,
    primaryVariant = paleWhite
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