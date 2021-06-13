import androidx.compose.desktop.Window
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.VerticalScrollbar
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollbarAdapter
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import components.QuoteItemCard
import repo.MainViewModel
import ui.JetQuotesTheme
import ui.typography
import utils.ViewState
import utils.copyToClipboard

fun main() = Window(title = "JetQuotes", resizable = false) {
    JetQuotesTheme(darkTheme = false) {
        Box(modifier = Modifier.fillMaxSize().background(MaterialTheme.colors.primary)) {
            QuotesList()
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun QuotesList() {
    val listState = rememberLazyListState()
    val viewModel = MainViewModel()
    val scope = rememberCoroutineScope()

    // init viewModel
    viewModel.init(scope = scope)
    viewModel.getAllQuotes()

    when (val result = viewModel.uiState.collectAsState().value) {
        ViewState.Empty -> {
            Text("Empty Quotes")

        }
        is ViewState.Error -> {
            Text("Error ${result.exception}")

        }
        ViewState.Loading -> {
            Text("Quotes Loading")
        }
        is ViewState.Success -> {

            Box {
                LazyColumn(
                    state = listState,
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(start = 40.dp)
                ) {

                    item {
                        Text(
                            "JetQuotes",
                            style = typography.h4,
                            textAlign = TextAlign.Start,
                            color = MaterialTheme.colors.onPrimary,
                            modifier = Modifier.padding(top = 24.dp, bottom = 24.dp)
                        )
                    }

                    items(result.quote) {
                        QuoteItemCard(it, onClick = {
                            copyToClipboard(
                                it.quoteText
                                    .plus("")
                                    .plus("- ${it.quoteAuthor}")
                            )
                        })
                    }
                }

                VerticalScrollbar(
                    modifier = Modifier.align(Alignment.CenterEnd).fillMaxHeight(),
                    adapter = rememberScrollbarAdapter(
                        listState,
                        result.quote.size,
                        12.dp
                    )
                )
            }

        }
    }
}
