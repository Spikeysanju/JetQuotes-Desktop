import androidx.compose.desktop.Window
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import components.QuoteItemCard
import repo.MainViewModel
import ui.JetQuotesTheme
import utils.ViewState
import utils.copyToClipboard

fun main() = Window {
    JetQuotesTheme(darkTheme = false) {
        Box(modifier = Modifier.fillMaxSize().background(MaterialTheme.colors.primary)) {
            QuotesList()
        }
    }
}


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
            LazyColumn(state = listState, contentPadding = PaddingValues(start = 40.dp)) {
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
        }
    }
}