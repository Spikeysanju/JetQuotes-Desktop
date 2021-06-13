package components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import model.QuoteItem
import ui.typography

@Composable
fun QuoteItemCard(quote: QuoteItem, onClick: () -> Unit) {
    Box(
        modifier = Modifier.fillMaxWidth().wrapContentHeight().background(MaterialTheme.colors.primaryVariant)
            .clickable {
                onClick()
            }
            .padding(start = 24.dp, top = 16.dp, end = 0.dp, bottom = 16.dp)
    ) {

        Column(modifier = Modifier.fillMaxWidth().wrapContentHeight(), horizontalAlignment = Alignment.Start) {
            Text("“", textAlign = TextAlign.Start, style = typography.h3, color = MaterialTheme.colors.onPrimary)
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                quote.quoteText,
                textAlign = TextAlign.Start,
                style = typography.subtitle1,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = MaterialTheme.colors.onPrimary
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                "- ".plus(quote.quoteAuthor.ifBlank { "- Unknown" }),
                textAlign = TextAlign.Start,
                style = typography.caption,
                color = MaterialTheme.colors.onPrimary.copy(0.6F)
            )

        }
    }
    Spacer(modifier = Modifier.height(12.dp))
}
