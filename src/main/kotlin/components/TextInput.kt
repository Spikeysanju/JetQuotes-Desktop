package components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import ui.typography

@Composable
fun LabelView(title: String) {
    Text(
        text = title,
        style = typography.caption,
        textAlign = TextAlign.Start,
        color = colors.onPrimary
    )
}


@ExperimentalComposeUiApi
@Composable
fun InputTextField(title: String, value: String, onValueChanged: (String) -> Unit) {
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = 16.dp),
        value = value,
        onValueChange = {
            onValueChanged(it)
        },
        singleLine = true,
        label = { LabelView(title = title) },
        textStyle = typography.body1,
        colors = textFieldColors(),
        leadingIcon = {
            Icon(imageVector = Icons.Sharp.Search, contentDescription = "Search Icon")
        }
    )

}

@Composable
fun textFieldColors() = TextFieldDefaults.textFieldColors(
    textColor = colors.onPrimary,
    focusedLabelColor = colors.onPrimary,
    unfocusedLabelColor = colors.onPrimary.copy(.5F),
    focusedIndicatorColor = colors.onPrimary,
    unfocusedIndicatorColor = colors.onPrimary.copy(.5F),
    cursorColor = colors.onPrimary,
    placeholderColor = colors.onPrimary,
    disabledPlaceholderColor = colors.onPrimary.copy(.5F),
    leadingIconColor = colors.onPrimary,
    disabledLeadingIconColor = colors.onPrimary.copy(.5F),
)