package components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerMoveFilter

@Composable
fun Modifier.addHoverEffect(
    onClicked: () -> Unit,
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
            onClicked()
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