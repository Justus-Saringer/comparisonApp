package com.example.composetesting.buttonsandtexts.button

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.example.composetesting.ui.theme.ComposeTestingTheme

class ButtonComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeTestingTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(text = "Button")
                            },
                            backgroundColor = MaterialTheme.colors.primary
                        )
                    }, content = {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(MaterialTheme.colors.background),
                            contentAlignment = Alignment.Center
                        ) {
                            ButtonExample()
                        }
                    }
                )
            }
        }
    }
}

@Composable
fun ButtonExample() {
    Button(
        colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primary),
        shape = MaterialTheme.shapes.large,
        onClick = { }
    ) {
        Text(
            text = "This is a text",
            style = MaterialTheme.typography.body1
        )
    }
}

@Preview(showSystemUi = true, showBackground = true, device = Devices.PIXEL_4)
@Composable
fun ButtonExamplePreview() {
    ComposeTestingTheme {
        ButtonExample()
    }
}