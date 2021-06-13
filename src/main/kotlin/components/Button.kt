package components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorXmlResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import model.QuoteItem
import repo.MainViewModel
import ui.R
import ui.typography
import utils.copyToClipboard

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
fun CTAButtons(viewModel: MainViewModel, quote: String, author: String) {
    Box(modifier = Modifier.fillMaxSize()) {
        Row(
            modifier = Modifier
                .background(MaterialTheme.colors.primaryVariant)
                .align(Alignment.BottomEnd)
                .padding(30.dp, 30.dp, 0.dp, 30.dp)
        ) {


            PrimaryButton(
                icon = vectorXmlResource("drawable/ic_heart.xml"),
                name = R.string.FAVOURITES,
                contentDescription = "",
                onClick = {
                    val quotes = QuoteItem(quote, author)

                })

            Spacer(modifier = Modifier.width(30.dp))

            PrimaryButton(
                icon = vectorXmlResource("drawable/ic_copy.xml"),
                name = R.string.COPY_TO_CLIPBOARD,
                contentDescription = "",
                onClick = {
                    copyToClipboard(quote.plus("").plus("- $author"))

                })

            Spacer(modifier = Modifier.width(30.dp))

            PrimaryButton(
                icon = vectorXmlResource("drawable/ic_share.xml"),
                name = R.string.SHARE,
                contentDescription = R.string.SHARE,
                onClick = {
                    copyToClipboard(quote.plus("").plus("- $author"))
                })

            Spacer(modifier = Modifier.width(30.dp))


        }
    }

}