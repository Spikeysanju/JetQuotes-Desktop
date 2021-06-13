package components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.vectorXmlResource
import androidx.compose.ui.unit.dp
import model.QuoteItem
import repo.MainViewModel
import utils.copyToClipboard

@Composable
fun CTAButtons(viewModel: MainViewModel, quote: String, author: String) {
    Box(modifier = Modifier.fillMaxSize()) {
        Row(
            modifier = Modifier
                .background(MaterialTheme.colors.primaryVariant)
                .align(Alignment.BottomEnd)
                .padding(30.dp, 30.dp, 0.dp, 30.dp)
        ) {


            Button(
                icon = vectorXmlResource("drawable/ic_heart.xml"),
                name = ui.R.string.FAVOURITES,
                contentDescription = "",
                onClick = {
                    val quotes = QuoteItem(quote, author)

                })

            Spacer(modifier = Modifier.width(30.dp))

            Button(
                icon = vectorXmlResource("drawable/ic_copy.xml"),
                name = ui.R.string.COPY_TO_CLIPBOARD,
                contentDescription = "",
                onClick = {
                    copyToClipboard(quote.plus("").plus("- $author"))

                })

            Spacer(modifier = Modifier.width(30.dp))

            Button(
                icon = vectorXmlResource("drawable/ic_share.xml"),
                name = ui.R.string.SHARE,
                contentDescription = ui.R.string.SHARE,
                onClick = {
                    copyToClipboard(quote.plus("").plus("- $author"))
                })

            Spacer(modifier = Modifier.width(30.dp))


        }
    }

}