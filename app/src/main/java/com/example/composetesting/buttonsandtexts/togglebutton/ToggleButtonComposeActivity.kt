package com.example.composetesting.buttonsandtexts.togglebutton

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.composetesting.ui.theme.ComposeTestingTheme

class ToggleButtonComposeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeTestingTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = { Text(text = "ToggleButton") },
                            backgroundColor = MaterialTheme.colors.primary,
                            contentColor = MaterialTheme.colors.onPrimary
                        )
                    }
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        ToggleButtonExample()
                    }
                }
            }
        }
    }
}

@Composable
fun ToggleButtonExample() {
    var buttonClicked by remember {
        mutableStateOf(false)
    }

    val buttonText: String
    val buttonTextColor: Color
    val buttonBackgroundColor: Color

    if (buttonClicked) {
        buttonText = "On"
        buttonTextColor = Color.Green
        buttonBackgroundColor = Color.LightGray
    } else {
        buttonText = "Off"
        buttonTextColor = Color.Red
        buttonBackgroundColor = Color.Gray
    }

    Button(
        onClick = { buttonClicked = !buttonClicked },
        colors = ButtonDefaults.buttonColors(backgroundColor = buttonBackgroundColor)
    ) {
        Text(text = buttonText, color = buttonTextColor)
    }
}

@Preview
@Composable
fun ToggleButtonExamplePreview() {
    ComposeTestingTheme {
        ToggleButtonExample()
    }
}