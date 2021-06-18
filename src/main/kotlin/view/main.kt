package view

import androidx.compose.desktop.Window
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.VerticalScrollbar
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollbarAdapter
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import components.EmptyState
import components.InputTextField
import components.LoadingState
import components.QuoteItemCard
import components.TopBar
import ui.JetQuotesTheme
import ui.R
import utils.ViewState
import utils.copyToClipboard
import viewmodel.MainViewModel
import java.awt.image.BufferedImage
import javax.imageio.ImageIO

fun main() = Window(title = R.string.APP_NAME, resizable = true, icon = getAppIcon()) {
    val darkTheme = remember { mutableStateOf(false) }
    JetQuotesTheme(darkTheme = darkTheme.value) {
        Box(modifier = Modifier.fillMaxSize().background(MaterialTheme.colors.primary)) {
            QuotesList(darkTheme.value, onToggle = {
                darkTheme.value = !darkTheme.value
            })
        }
    }
}

@OptIn(ExperimentalFoundationApi::class, androidx.compose.ui.ExperimentalComposeUiApi::class)
@Composable
fun QuotesList(isDarkTheme: Boolean, onToggle: () -> Unit) {

    // States
    val listState = rememberLazyListState()
    val search = remember { mutableStateOf("") }
    val scope = rememberCoroutineScope()

    // init viewModel
    val viewModel = MainViewModel()
    viewModel.init(scope = scope)
    viewModel.getAllQuotes()

    // Observe quotes
    when (val result = viewModel.uiState.collectAsState().value) {
        ViewState.Empty -> {

            EmptyState(
                onActionClick = {
                    // go back to home
                    viewModel.getAllQuotes()
                },
                title = R.string.EMPTY_TITLE,
                description = R.string.EMPTY_DESCRIPTION,
                image = imageResource("drawable/empty_state.png"),
                actionName = R.string.BACK_TO_HOME
            )
        }
        is ViewState.Error -> {
            Text("Error", color = MaterialTheme.colors.onPrimary)
        }
        ViewState.Loading -> {
            LoadingState()
        }
        is ViewState.Success -> {
            Box {
                LazyColumn(
                    state = listState,
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(start = 40.dp)
                ) {

                    // TobBar
                    item {
                        TopBar(onToggle = {
                            onToggle()
                        }, isDarkTheme = isDarkTheme)
                    }

                    // Search input field
                    item {
                        InputTextField(R.string.SEARCH, search.value, onValueChanged = {
                            search.value = it
                        })
                    }

                    // quotes list
                    items(result.quote.filter {

                        // Filter search by Quote or Author
                        it.quoteText.contains(
                            search.value,
                            ignoreCase = true
                        ) || it.quoteAuthor.contains(search.value, ignoreCase = true)
                    }) {
                        Spacer(modifier = Modifier.height(24.dp))
                        QuoteItemCard(it, onClick = {
                            copyToClipboard(
                                it.quoteText
                                    .plus("")
                                    .plus("- ${it.quoteAuthor}")
                            )
                        })
                    }
                }

                // vertical end scrollbar
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

private fun getAppIcon(): BufferedImage {
    return ImageIO.read(MainViewModel::class.java.classLoader.getResourceAsStream("drawable/ic_jetquotes_logo.png"))
}
