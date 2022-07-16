package com.example.composetesting.layouts.linearlayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.composetesting.ui.theme.BlueBell
import com.example.composetesting.ui.theme.Cadet
import com.example.composetesting.ui.theme.ComposeTestingTheme
import com.example.composetesting.ui.theme.DavysGrey

class LinearLayoutComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeTestingTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(text = "LinearLayout")
                            },
                            backgroundColor = MaterialTheme.colors.primary
                        )
                    }, content = {
                        LinearLayoutExample()
                    }
                )
            }
        }
    }
}

@Composable
fun LinearLayoutExample() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .background(BlueBell),
            text = "Hello World",
            textAlign = TextAlign.Center
        )

        Button(
            modifier = Modifier
                .fillMaxWidth(),
//                .background(Cadet),
            colors = ButtonDefaults.buttonColors(contentColor = Color.White),
            onClick = { }) {
            Text(text = "This is a button")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LinearLayoutExamplePreview() {
    ComposeTestingTheme {
        LinearLayoutExample()
    }
}