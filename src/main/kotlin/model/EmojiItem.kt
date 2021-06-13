package model

import kotlinx.serialization.Serializable

@Serializable
data class EmojiItem(
    val quoteAuthor: String,
    val quoteText: String
)