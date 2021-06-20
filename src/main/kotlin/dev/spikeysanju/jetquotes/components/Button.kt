package dev.spikeysanju.jetquotes.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorXmlResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import dev.spikeysanju.jetquotes.ui.R
import dev.spikeysanju.jetquotes.ui.typography

@Composable
fun PrimaryButton(icon: ImageVector, name: String, contentDescription: String, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .clickable { onClick() }
            .background(MaterialTheme.colors.primaryVariant)
            .padding(12.dp)
    ) {

        Icon(
            imageVector = icon,
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

@Composable
fun CopyButton(onClick: () -> Unit) {
    Row(
        modifier = Modifier.wrapContentSize().padding(end = 16.dp).clickable { onClick() },
        horizontalArrangement = Arrangement.SpaceAround,
    ) {
        Icon(
            imageVector = vectorXmlResource("drawable/ic_copy.xml"),
            R.string.COPY_TO_CLIPBOARD,
            tint = MaterialTheme.colors.onPrimary
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            "Copy to Clipboard",
            style = typography.caption,
            textAlign = TextAlign.Start,
            color = MaterialTheme.colors.onPrimary
        )
    }
}