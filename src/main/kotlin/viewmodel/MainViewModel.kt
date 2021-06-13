package viewmodel

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import model.QuoteItem
import utils.ViewState
import java.io.File

class MainViewModel {

    // Backing property to avoid state updates from other classes
    private val _uiState = MutableStateFlow<ViewState>(ViewState.Loading)
    private val _search = MutableStateFlow<String>("")


    // UI collects from this StateFlow to get it's state update
    val uiState = _uiState.asStateFlow()
    val search = _search.asStateFlow()

    private lateinit var viewModelScope: CoroutineScope
    fun init(scope: CoroutineScope) {
        this.viewModelScope = scope
    }

    fun inputValue(text: String) = viewModelScope.launch(Dispatchers.IO) {
        _search.value = text
    }

    /**
     * To get all quotes from Json
     */
    fun getAllQuotes() = viewModelScope.launch(Dispatchers.IO) {
        /* filePath */
        val quotes = "/Users/spikeysanju/JetQuotes/src/main/resources/assets/quotes.json"

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

    /**
     * To get all quotes from Json
     */
    fun searchQuotes(text: String) = viewModelScope.launch(Dispatchers.IO) {
        /* filePath */
        val quotes = "/Users/spikeysanju/JetQuotes/src/main/resources/assets/quotes.json"

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
            _uiState.value = ViewState.Success(
                format.decodeFromString<List<QuoteItem>>(quotesJson).filter { it.quoteText.contains(text) })
        } catch (e: Exception) {
            e.printStackTrace()
            _uiState.value = ViewState.Error(e.message ?: "Something went wrong")
        }
    }


}