package dev.spikeysanju.jetquotes.view.quotes

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.VerticalScrollbar
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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.spikeysanju.jetquotes.components.EmptyState
import dev.spikeysanju.jetquotes.components.ErrorState
import dev.spikeysanju.jetquotes.components.InputTextField
import dev.spikeysanju.jetquotes.components.LoadingState
import dev.spikeysanju.jetquotes.components.QuoteItemCard
import dev.spikeysanju.jetquotes.components.TopBar
import dev.spikeysanju.jetquotes.ui.R
import dev.spikeysanju.jetquotes.utils.ViewState
import dev.spikeysanju.jetquotes.utils.copyToClipboard
import dev.spikeysanju.jetquotes.viewmodel.MainViewModel

@OptIn(ExperimentalFoundationApi::class, androidx.compose.ui.ExperimentalComposeUiApi::class)
@Composable
fun QuotesListScreen(viewModel: MainViewModel) {

    // States
    val listState = rememberLazyListState()
    val search = remember { mutableStateOf("") }

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
                image = "drawable/ic_empty.xml",
                actionName = R.string.BACK_TO_HOME
            )
        }

        is ViewState.Error -> {
            ErrorState(
                title = R.string.ERROR_TITLE,
                description = result.exception,
                image = "drawable/ic_error.xml"
            )
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
                        TopBar()
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
                    adapter = rememberScrollbarAdapter(listState)
                )
            }

        }
    }
}
