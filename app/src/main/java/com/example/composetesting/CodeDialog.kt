package com.example.composetesting

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.composetesting.ui.theme.ComposeTestingTheme

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun CodeDialog(
    modifier: Modifier = Modifier,
    codeID: String,
    onDismiss: () -> Unit
) {
    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        Column(
            modifier = modifier
                .padding(16.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(MaterialTheme.colors.background)
                .padding(8.dp)
        ) {

            when (codeID) {

            }
            Text(
                modifier = Modifier.padding(16.dp),
                text = "Hello World"
            )

            Button(
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .fillMaxWidth()
                    .height(56.dp)
                    .background(MaterialTheme.colors.surface),
                onClick = onDismiss
            ) {
                Text(text = "Verstanden")
            }
        }
    }
}

@Preview
@Composable
fun CodeDialogPreview() {
    ComposeTestingTheme {
        CodeDialog(codeID = "constraint") {}
    }
}