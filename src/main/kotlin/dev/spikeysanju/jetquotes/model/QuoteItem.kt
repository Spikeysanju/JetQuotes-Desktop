package dev.spikeysanju.jetquotes.model

import kotlinx.serialization.Serializable

@Serializable
data class QuoteItem(
    val quoteAuthor: String,
    val quoteText: String
)