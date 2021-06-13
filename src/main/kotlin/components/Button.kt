package components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import ui.typography

@Composable
fun Button(icon: Painter, name: String, contentDescription: String) {
    Column(
        modifier = Modifier
            .background(MaterialTheme.colors.primaryVariant)
            .padding(12.dp)
    ) {

        Icon(
            painter = icon,
            contentDescription = contentDescription
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = name,
            maxLines = 1,
            style = typography.overline,
            color = MaterialTheme.colors.onBackground,
            overflow = TextOverflow.Ellipsis
        )
    }

}