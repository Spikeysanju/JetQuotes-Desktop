package viewmodel

import dev.spikeysanju.jetquotes.utils.ViewState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.jetbrains.skija.impl.Log
import java.io.File

class MainViewModel {

    // Backing property to avoid state updates from other classes
    private val _uiState = MutableStateFlow<ViewState>(ViewState.Loading)

    // UI collects from this StateFlow to get it's state update
    val uiState = _uiState.asStateFlow()

    private lateinit var viewModelScope: CoroutineScope
    fun init(scope: CoroutineScope) {
        this.viewModelScope = scope
    }

    /**
     * To tell viewModel about empty search
     */
    fun emptySearch() = viewModelScope.launch(Dispatchers.IO) {
        _uiState.value = ViewState.Empty
        Log.info("Empty search!")
    }

    /**
     * To get all quotes from Json
     */
    fun getAllQuotes() = viewModelScope.launch(Dispatchers.IO) {
        /* filePath */
        val quotes = "/Users/spikey/IdeaProjects/JetQuotes-Desktop/src/main/resources/assets/quotes.json"

        /* reading json file */
        val quotesJson = File(quotes).readText()

        /* format json */
        val format = Json {
            ignoreUnknownKeys = true
            prettyPrint = true
            isLenient = true
        }

        /* decode from string (JSON) */
        try {
            _uiState.value = ViewState.Success(format.decodeFromString(quotesJson))
        } catch (e: Exception) {
            e.printStackTrace()
            _uiState.value = ViewState.Error(e.message ?: "Something went wrong")
        }
    }
}