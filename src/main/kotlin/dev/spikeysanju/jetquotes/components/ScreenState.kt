package dev.spikeysanju.jetquotes.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.vectorXmlResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import dev.spikeysanju.jetquotes.ui.R
import dev.spikeysanju.jetquotes.ui.typography

@Composable
fun LoadingState() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        CircularProgressIndicator()
    }
}

@Composable
fun EmptyState(title: String, description: String, image: String, actionName: String, onActionClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.onPrimary)
            .wrapContentSize(Alignment.Center), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ContentImage(image)
        Text(
            text = title,
            modifier = Modifier.fillMaxWidth(),
            style = typography.h6,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = description,
            modifier = Modifier.fillMaxWidth(),
            style = typography.body2,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colors.onPrimary.copy(.7f)
        )
        Spacer(modifier = Modifier.height(24.dp))
        Button(
            onClick = { onActionClick() }, colors = ButtonDefaults.buttonColors(
                backgroundColor = MaterialTheme.colors.onPrimary,
                contentColor = MaterialTheme.colors.primary
            )
        ) {
            Text(text = actionName)
        }
    }
}


@Composable
fun ContentImage(image: String) {
    Image(vectorXmlResource(image), R.string.EMPTY_STATE, modifier = Modifier.size(300.dp))
}


@Composable
fun ErrorState(title: String, description: String, image: String) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

        Column {
            ContentImage(image)

            Text(
                text = title,
                modifier = Modifier.fillMaxWidth(),
                style = typography.h6,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = description,
                modifier = Modifier.fillMaxWidth(),
                style = typography.body2,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colors.onPrimary.copy(.7f)
            )
        }
    }
}