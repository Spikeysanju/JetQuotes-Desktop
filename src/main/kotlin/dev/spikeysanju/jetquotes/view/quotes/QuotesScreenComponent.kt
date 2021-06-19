package dev.spikeysanju.jetquotes.view.quotes

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import com.arkivanov.decompose.ComponentContext
import dev.spikeysanju.jetquotes.navigation.Component
import dev.spikeysanju.jetquotes.viewmodel.MainViewModel

class QuotesScreenComponent(
    componentContext: ComponentContext,
    private val isDarkTheme: Boolean,
) : Component {

    var viewModel: MainViewModel = MainViewModel()

    @Composable
    override fun render() {

        val scope = rememberCoroutineScope()
        LaunchedEffect(viewModel) {
            viewModel.init(scope)
            viewModel.getAllQuotes()
        }

        QuotesListScreen(viewModel, isDarkTheme = isDarkTheme)

    }

}