package com.example.composetesting.layouts

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.Dialog
import com.example.composetesting.CodeDialog
import com.example.composetesting.comparebutton.CompareItem
import com.example.composetesting.layouts.constraintlayout.ConstraintLayoutComposeActivity
import com.example.composetesting.layouts.constraintlayout.ConstraintLayoutViewActivity
import com.example.composetesting.ui.theme.ComposeTestingTheme

class LayoutActivity : AppCompatActivity() {
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
                    LayoutScreen()
                }
            }
        }
    }
}

@Composable
private fun LayoutScreen() {

    val scrollState = rememberScrollState()
    var isDialogShown by remember { mutableStateOf(true) }

    LazyColumn(
        modifier = Modifier.scrollable(scrollState, Orientation.Vertical)
    ) {
        item {
            CompareItem(
                title = "ConstraintLayout",
                composeActivity = ConstraintLayoutComposeActivity::class.java,
                androidViewActivity = ConstraintLayoutViewActivity::class.java,
            )
        }
    }

    if (isDialogShown) {
        CodeDialog(codeID = "con") {
            isDialogShown = false
        }
    }
}

@Preview(showBackground = true, showSystemUi = false, device = Devices.PIXEL_4)
@Composable
private fun LayoutScreenPreview() {
    MaterialTheme {
        LayoutScreen()
    }
}