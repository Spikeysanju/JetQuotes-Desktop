package dev.spikeysanju.jetquotes.utils

import java.awt.Toolkit
import java.awt.datatransfer.StringSelection

fun copyToClipboard(value: String) {
    Toolkit.getDefaultToolkit()
        .systemClipboard
        .setContents(
            StringSelection(value),
            null
        )
}
