package dev.spikeysanju.jetquotes.navigation

import com.arkivanov.decompose.statekeeper.Parcelable

/**
 * All Screens
 */
sealed class Screen : Parcelable {
    object Splash : Screen()
    object Quotes : Screen()
}
