package utils

import model.QuoteItem

sealed class ViewState {
    // Represents different states for quotes
    object Empty : ViewState()
    object Loading : ViewState()
    data class Success(val quote: List<QuoteItem>) : ViewState()
    data class Error(val exception: String) : ViewState()
}