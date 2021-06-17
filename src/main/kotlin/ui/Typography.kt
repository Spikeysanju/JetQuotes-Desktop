package ui

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.platform.Font
import androidx.compose.ui.unit.sp

val futura = FontFamily(
    Font("fonts/Jost-Light.ttf", FontWeight.Light),
    Font("fonts/Jost-Regular.ttf", FontWeight.Normal),
    Font("fonts/Jost-SemiBold.ttf", FontWeight.SemiBold),
)

// Set of Material typography styles to start with
val typography = Typography(
    h1 = TextStyle(
        fontFamily = futura,
        fontWeight = FontWeight.W600,
        fontSize = 60.sp
    ),
    h2 = TextStyle(
        fontFamily = futura,
        fontWeight = FontWeight.W600,
        fontSize = 48.sp
    ),
    h3 = TextStyle(
        fontFamily = futura,
        fontWeight = FontWeight.W600,
        fontSize = 36.sp
    ),
    h4 = TextStyle(
        fontFamily = futura,
        fontWeight = FontWeight.W600,
        fontSize = 30.sp
    ),
    h5 = TextStyle(
        fontFamily = futura,
        fontWeight = FontWeight.W600,
        fontSize = 24.sp
    ),
    h6 = TextStyle(
        fontFamily = futura,
        fontWeight = FontWeight.W600,
        fontSize = 20.sp
    ),
    subtitle1 = TextStyle(
        fontFamily = futura,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    subtitle2 = TextStyle(
        fontFamily = futura,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    body1 = TextStyle(
        fontFamily = futura,
        fontWeight = FontWeight.Light,
        fontSize = 16.sp
    ),
    body2 = TextStyle(
        fontFamily = futura,
        fontSize = 14.sp,
        lineHeight = 20.sp
    ),
    button = TextStyle(
        fontFamily = futura,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = futura,
        fontWeight = FontWeight.Light,
        fontSize = 12.sp
    ),
    overline = TextStyle(
        fontFamily = futura,
        fontWeight = FontWeight.W500,
        fontSize = 12.sp

    )
)