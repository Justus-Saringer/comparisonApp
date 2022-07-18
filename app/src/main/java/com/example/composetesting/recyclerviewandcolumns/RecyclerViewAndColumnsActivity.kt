package com.example.composetesting.recyclerviewandcolumns

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
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.composetesting.CodeDialog
import com.example.composetesting.comparebutton.CompareItem
import com.example.composetesting.ui.theme.ComposeTestingTheme

class RecyclerViewAndColumnsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeTestingTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = { Text(text = "Layouts") },
                            backgroundColor = MaterialTheme.colors.primary,
                            contentColor = MaterialTheme.colors.onPrimary
                        )
                    }
                ) {
                    RecyclerViewAndColumnsScreen()
                }
            }
        }
    }
}

@Composable
fun RecyclerViewAndColumnsScreen() {

    val scrollState = rememberScrollState()
    var isDialogShown by remember { mutableStateOf(false) }
    var layoutId by remember { mutableStateOf("") }

    LazyColumn(
        modifier = Modifier.scrollable(scrollState, Orientation.Vertical)
    ) {
        item {
            CompareItem(
                title = "RecyclerView / Column",
                composeActivity = ColumnComposeActivity::class.java,
                androidViewActivity = RecyclerViewActivity::class.java,
                composeCodeClick = {
                    layoutId = "compose_recycler"
                    isDialogShown = true
                },
                viewCodeClick = {
                    layoutId = "view_recycler"
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
fun RecyclerViewAndColumnsScreenPreview() {
    ComposeTestingTheme {
        RecyclerViewAndColumnsScreen()
    }
}