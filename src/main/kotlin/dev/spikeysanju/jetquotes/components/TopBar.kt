package dev.spikeysanju.jetquotes.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.vectorXmlResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import dev.spikeysanju.jetquotes.ui.R
import dev.spikeysanju.jetquotes.ui.typography

@Composable
fun TopBar(isDarkTheme: Boolean, onToggle: () -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            R.string.APP_NAME,
            style = typography.h4,
            textAlign = TextAlign.Start,
            color = MaterialTheme.colors.onPrimary,
            modifier = Modifier.padding(start = 24.dp, top = 24.dp, bottom = 24.dp)
        )

        Spacer(modifier = Modifier.width(16.dp))

        /**
         * Show day/night icon on toggle depends upon the theme
         */
        val icon = vectorXmlResource(
            when (isDarkTheme) {
                false -> "drawable/ic_day.xml"
                true -> "drawable/ic_night.xml"
            }
        )

        Icon(
            imageVector = icon,
            R.string.COPY_TO_CLIPBOARD,
            tint = MaterialTheme.colors.onPrimary,
            modifier = Modifier.clickable {
                onToggle()
            }
        )
    }
}