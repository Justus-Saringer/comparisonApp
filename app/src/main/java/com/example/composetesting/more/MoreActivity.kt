package com.example.composetesting.more

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.composetesting.CodeDialog
import com.example.composetesting.comparebutton.CompareItem
import com.example.composetesting.more.custom.CustomViewComposeActivity
import com.example.composetesting.more.custom.CustomViewViewActivity
import com.example.composetesting.ui.theme.ComposeTestingTheme

class MoreActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeTestingTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = { Text(text = "More") },
                            backgroundColor = MaterialTheme.colors.primary,
                            contentColor = MaterialTheme.colors.onPrimary
                        )
                    }
                ) {
                    MoreScreen()
                }
            }
        }
    }
}

@Composable
fun MoreScreen() {

    val scrollState = rememberScrollState()
    var isDialogShown by remember { mutableStateOf(false) }
    var layoutId by remember { mutableStateOf("") }

    LazyColumn(
        modifier = Modifier.scrollable(scrollState, Orientation.Vertical)
    ) {
        item {
            CompareItem(
                title = "CustomView",
                composeActivity = CustomViewComposeActivity::class.java,
                androidViewActivity = CustomViewViewActivity::class.java,
                composeCodeClick = {
                    layoutId = "customView"
                    isDialogShown = true
                },
                viewCodeClick = {
                    layoutId = "customView"
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