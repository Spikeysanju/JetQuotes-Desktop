package ui

import androidx.compose.material.Typography
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.platform.Font

val futura = FontFamily(
    Font("fonts/Jost-Light.ttf", FontWeight.Light),
    Font("fonts/Jost-Regular.ttf", FontWeight.Normal),
    Font("fonts/Jost-SemiBold.ttf", FontWeight.SemiBold),
)

val typography = Typography(defaultFontFamily = futura)