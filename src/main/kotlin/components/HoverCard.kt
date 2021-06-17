package components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerMoveFilter

@Composable
fun Modifier.addHoverEffect(
    onClicked: (Boolean) -> Unit,
    defaultColor: Color,
    onHoverColor: Color
): Modifier {
    var onHover by remember { mutableStateOf(false) }
    val background = if (onHover) {
        onHoverColor
    } else {
        defaultColor
    }

    return this
        .background(background)
        .clickable {
            onClicked(onHover)
        }
        .pointerMoveFilter(
            onEnter = {
                onHover = true
                false
            },
            onExit = {
                onHover = false
                false
            }
        )
}