package com.example.composetesting

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
    codeId: String,
    onDismiss: () -> Unit
) {

    val scrollState = rememberScrollState()

    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        Column(
            modifier = modifier
                .padding(16.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(MaterialTheme.colors.background)
                .verticalScroll(scrollState)
                .padding(8.dp)
        ) {

            Text(
                modifier = Modifier.padding(16.dp),
                text = getCode(id = codeId)
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

@Composable
private fun getCode(id: String): String {
    return when (id) {
        "compose_constraint" -> stringResource(id = R.string.compose_constraint)
        "view_constraint" -> stringResource(id = R.string.view_constraint)

        "compose_linear" -> stringResource(id = R.string.compose_linear)
        "view_linear" -> stringResource(id = R.string.view_linear)

        "compose_frame" -> stringResource(id = R.string.compose_frame)
        "view_frame" -> stringResource(id = R.string.view_frame)

        "compose_grid" -> stringResource(id = R.string.compose_grid)
        "view_grid" -> stringResource(id = R.string.view_grid)
        
        "compose_button" -> stringResource(id = R.string.compose_button)
        "view_button" -> stringResource(id = R.string.view_button)
        else -> {
            "An error occurred!"
        }
    }
}

@Preview
@Composable
fun CodeDialogPreview() {
    ComposeTestingTheme {
        CodeDialog(codeId = "constraint") {}
    }
}