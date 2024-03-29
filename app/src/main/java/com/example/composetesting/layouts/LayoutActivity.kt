package com.example.composetesting.layouts

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
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.example.composetesting.CodeDialog
import com.example.composetesting.comparebutton.CompareItem
import com.example.composetesting.layouts.constraintlayout.ConstraintLayoutComposeActivity
import com.example.composetesting.layouts.constraintlayout.ConstraintLayoutViewActivity
import com.example.composetesting.layouts.framelyout.FrameLayoutComposeActivity
import com.example.composetesting.layouts.framelyout.FrameLayoutViewActivity
import com.example.composetesting.layouts.gridlayout.GridLayoutComposeActivity
import com.example.composetesting.layouts.gridlayout.GridLayoutViewActivity
import com.example.composetesting.layouts.linearlayout.LinearLayoutComposeActivity
import com.example.composetesting.layouts.linearlayout.LinearLayoutViewActivity
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
    var isDialogShown by remember { mutableStateOf(false) }
    var layoutId by remember { mutableStateOf("") }

    LazyColumn(
        modifier = Modifier.scrollable(scrollState, Orientation.Vertical)
    ) {
        item {
            CompareItem(
                title = "ConstraintLayout",
                composeActivity = ConstraintLayoutComposeActivity::class.java,
                androidViewActivity = ConstraintLayoutViewActivity::class.java,
                composeCodeClick = {
                    layoutId = "compose_constraint"
                    isDialogShown = true
                },
                viewCodeClick = {
                    layoutId = "view_constraint"
                    isDialogShown = true
                }
            )
        }

        item {
            CompareItem(
                title = "LinearLayout/Column",
                composeActivity = LinearLayoutComposeActivity::class.java,
                androidViewActivity = LinearLayoutViewActivity::class.java,
                composeCodeClick = {
                    layoutId = "compose_linear"
                    isDialogShown = true
                },
                viewCodeClick = {
                    layoutId = "view_linear"
                    isDialogShown = true
                }
            )
        }

        item {
            CompareItem(
                title = "FrameLayout/Box",
                composeActivity = FrameLayoutComposeActivity::class.java,
                androidViewActivity = FrameLayoutViewActivity::class.java,
                composeCodeClick = {
                    layoutId = "compose_frame"
                    isDialogShown = true
                },
                viewCodeClick = {
                    layoutId = "view_frame"
                    isDialogShown = true
                }
            )
        }

        item {
            CompareItem(
                title = "GridLayout",
                composeActivity = GridLayoutComposeActivity::class.java,
                androidViewActivity = GridLayoutViewActivity::class.java,
                composeCodeClick = {
                    layoutId = "compose_grid"
                    isDialogShown = true
                },
                viewCodeClick = {
                    layoutId = "view_grid"
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

@Preview(showBackground = true, showSystemUi = false, device = Devices.PIXEL_4)
@Composable
private fun LayoutScreenPreview() {
    MaterialTheme {
        LayoutScreen()
    }
}