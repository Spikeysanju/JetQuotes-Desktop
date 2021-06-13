package ui

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import ui.AppColor.black
import ui.AppColor.paleBlack
import ui.AppColor.paleWhite
import ui.AppColor.white

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