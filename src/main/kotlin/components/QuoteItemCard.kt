package components

import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerMoveFilter
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import model.QuoteItem
import ui.R
import ui.typography

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun QuoteItemCard(quote: QuoteItem, onClick: () -> Unit) {
    var onHover by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier.fillMaxWidth().wrapContentHeight()
            .pointerMoveFilter(
                onEnter = {
                    onHover = true
                    false
                },
                onExit = {
                    onHover = false
                    false
                }
            ).background(if (onHover) colors.onBackground else colors.primaryVariant)
            .padding(start = 24.dp, top = 16.dp, end = 0.dp, bottom = 16.dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth().wrapContentHeight(), horizontalAlignment = Alignment.Start) {

            Row(modifier = Modifier.fillMaxSize(), horizontalArrangement = Arrangement.End) {
                // Show copy button on hover only

                AnimatedVisibility(
                    visible = onHover,
                    enter = fadeIn() + expandVertically(),
                    exit = fadeOut() + shrinkVertically()
                ) {
                    CopyButton {
                        onClick()
                    }
                }
            }

            // hyphen symbol
            Text(
                R.string.QUOTATION,
                textAlign = TextAlign.Start,
                style = typography.h3,
                color = colors.onPrimary
            )
            Spacer(modifier = Modifier.height(8.dp))

            // quote
            Text(
                quote.quoteText,
                textAlign = TextAlign.Start,
                style = typography.subtitle1,
                overflow = TextOverflow.Ellipsis,
                color = colors.onPrimary
            )
            Spacer(modifier = Modifier.height(12.dp))

            // author
            Text(
                R.string.HYPHEN.plus(quote.quoteAuthor.ifBlank { R.string.UNKNOWN_AUTHOR }),
                textAlign = TextAlign.Start,
                style = typography.caption,
                color = colors.onPrimary.copy(0.6F)
            )

        }
    }
    Spacer(modifier = Modifier.height(12.dp))
}
