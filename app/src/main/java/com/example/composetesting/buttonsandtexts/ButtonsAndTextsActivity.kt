package com.example.composetesting.buttonsandtexts

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.composetesting.CodeDialog
import com.example.composetesting.buttonsandtexts.button.ButtonComposeActivity
import com.example.composetesting.buttonsandtexts.button.ButtonViewActivity
import com.example.composetesting.comparebutton.CompareItem
import com.example.composetesting.ui.theme.ComposeTestingTheme

class ButtonsAndTextsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeTestingTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = { Text(text = "Buttons and Texts") },
                            backgroundColor = MaterialTheme.colors.primary,
                            contentColor = MaterialTheme.colors.onPrimary
                        )
                    }
                ) {
                    ButtonsScreen()
                }
            }
        }
    }
}

@Composable
fun ButtonsScreen() {
    val scrollState = rememberScrollState()
    var isDialogShown by remember { mutableStateOf(false) }
    var layoutId by remember { mutableStateOf("") }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .scrollable(scrollState, orientation = Orientation.Vertical)
    ) {
        item {
            CompareItem(
                title = "Buttons",
                composeActivity = ButtonComposeActivity::class.java,
                androidViewActivity = ButtonViewActivity::class.java,
                composeCodeClick = {
                    layoutId = "compose_button"
                    isDialogShown = true
                },
                viewCodeClick = {
                    layoutId = "view_button"
                    isDialogShown = true
                }
            )
        }
    }

    if (isDialogShown && layoutId.isNotEmpty()) {
        CodeDialog(codeId = layoutId) {
            isDialogShown = false
        }
    }
}

@Preview
@Composable
fun ButtonsScreenPreview() {

}