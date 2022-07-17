package com.example.composetesting.buttonsandtexts.textfield

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composetesting.ui.theme.ComposeTestingTheme

class TextFieldComposeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeTestingTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = { Text(text = "TextField") },
                            backgroundColor = MaterialTheme.colors.primary,
                            contentColor = MaterialTheme.colors.onPrimary
                        )
                    }
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            TextFieldExample()
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun TextFieldExample() {
    var text by remember { mutableStateOf("") }

    TextField(
        modifier = Modifier.width(250.dp),
        value = text,
        onValueChange = { text = it },
        placeholder = { Text(text = "This is a text")}
    )
}

@Preview
@Composable
fun TextFieldExamplePrev() {
    ComposeTestingTheme {
        TextFieldExample()
    }
}