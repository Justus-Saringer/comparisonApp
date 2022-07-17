package com.example.composetesting.buttonsandtexts.radiogroups

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composetesting.ui.theme.ComposeTestingTheme

class RadioGroupComposeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeTestingTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = { Text(text = "RadioGroup") },
                            backgroundColor = MaterialTheme.colors.primary,
                            contentColor = MaterialTheme.colors.onPrimary
                        )
                    }
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        RadioGroupExample()
                    }
                }
            }
        }
    }
}

@Composable
fun RadioGroupExample() {
    val stringList = listOf(
        "First Radio Button",
        "Second Radio Button",
        "Third Radio Button"
    )

    var rememberObserver by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        stringList.forEach { item ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                RadioButton(
                    selected = rememberObserver == item,
                    onClick = {
                        rememberObserver = item
                    }
                )
                Text(
                    text = item,
                    modifier = Modifier.clickable { rememberObserver = item }
                )
            }
        }
    }
}

@Preview
@Composable
fun RadioGroupExamplePreview() {
    ComposeTestingTheme {
        RadioGroupExample()
    }
}