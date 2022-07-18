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
import com.example.composetesting.buttonsandtexts.radiogroups.RadioGroupComposeActivity
import com.example.composetesting.buttonsandtexts.radiogroups.RadioGroupViewActivity
import com.example.composetesting.buttonsandtexts.text.TextViewActivity
import com.example.composetesting.buttonsandtexts.text.TextViewComposeActivity
import com.example.composetesting.buttonsandtexts.textfield.TextFieldComposeActivity
import com.example.composetesting.buttonsandtexts.textfield.TextFieldViewActivity
import com.example.composetesting.buttonsandtexts.togglebutton.ToggleButtonComposeActivity
import com.example.composetesting.buttonsandtexts.togglebutton.ToggleButtonViewActivity
import com.example.composetesting.comparebutton.CompareItem
import com.example.composetesting.ui.theme.ComposeTestingTheme

// TODO: Refactor RadioGroup Compose Dialog string
// TODO: Rearrange view RadioGroup, more center

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
                    ButtonsAndTextsScreen()
                }
            }
        }
    }
}

@Composable
fun ButtonsAndTextsScreen() {
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
                title = "Button",
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

        item {
            CompareItem(
                title = "Text",
                composeActivity = TextViewComposeActivity::class.java,
                androidViewActivity = TextViewActivity::class.java,
                composeCodeClick = {
                    layoutId = "compose_text"
                    isDialogShown = true
                },
                viewCodeClick = {
                    layoutId = "view_text"
                    isDialogShown = true
                }
            )
        }

        item {
            CompareItem(
                title = "TextField",
                composeActivity = TextFieldComposeActivity::class.java,
                androidViewActivity = TextFieldViewActivity::class.java,
                composeCodeClick = {
                    layoutId = "compose_textfield"
                    isDialogShown = true
                },
                viewCodeClick = {
                    layoutId = "view_textfield"
                    isDialogShown = true
                }
            )
        }

        item {
            CompareItem(
                title = "ToggleButton",
                composeActivity = ToggleButtonComposeActivity::class.java,
                androidViewActivity = ToggleButtonViewActivity::class.java,
                composeCodeClick = {
                    layoutId = "compose_toggle"
                    isDialogShown = true
                },
                viewCodeClick = {
                    layoutId = "view_toggle"
                    isDialogShown = true
                }
            )
        }

        item {
            CompareItem(
                title = "RadioGroup",
                composeActivity = RadioGroupComposeActivity::class.java,
                androidViewActivity = RadioGroupViewActivity::class.java,
                composeCodeClick = {
                    layoutId = "compose_radio"
                    isDialogShown = true
                },
                viewCodeClick = {
                    layoutId = "view_radio"
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
    ButtonsAndTextsScreen()
}