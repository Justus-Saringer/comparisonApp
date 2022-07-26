package com.example.composetesting.bars


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
import com.example.composetesting.bars.toolbar.ToolbarComposeActivity
import com.example.composetesting.bars.toolbar.ToolbarViewActivity
import com.example.composetesting.comparebutton.CompareItem
import com.example.composetesting.ui.theme.ComposeTestingTheme

class BarsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeTestingTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = { Text(text = "Bars") },
                            backgroundColor = MaterialTheme.colors.primary,
                            contentColor = MaterialTheme.colors.onPrimary
                        )
                    }
                ) {
                    BarsScreen()
                }
            }
        }
    }
}

@Composable
fun BarsScreen() {
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
                title = "Toolbar",
                composeActivity = ToolbarComposeActivity::class.java,
                androidViewActivity = ToolbarViewActivity::class.java,
                composeCodeClick = {
                    layoutId = "compose_toolbar"
                    isDialogShown = true
                },
                viewCodeClick = {
                    layoutId = "view_toolbar"
                    isDialogShown = true
                }
            )
        }

//        item {
//            CompareItem(
//                title = "BottomAppBar",
//                composeActivity = ,
//                androidViewActivity = ,
//                composeCodeClick = { },
//                viewCodeClick = { }
//            )
//        }
    }

    if (isDialogShown && layoutId.isNotEmpty()) {
        CodeDialog(codeId = layoutId) {
            isDialogShown = false
        }
    }
}

@Preview
@Composable
fun BarsScreenPreview() {
    BarsScreen()
}