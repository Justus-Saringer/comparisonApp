package com.example.composetesting.layouts.framelyout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composetesting.ui.theme.ComposeTestingTheme
import com.example.composetesting.ui.theme.DavysGrey

class FrameLayoutComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeTestingTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(text = "FrameLayout")
                            },
                            backgroundColor = MaterialTheme.colors.primary
                        )
                    }, content = {
                        FrameLayoutExample()
                    }
                )
            }
        }
    }
}

@Composable
fun FrameLayoutExample() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .size(200.dp)
                .background(DavysGrey)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun FrameLayoutExamplePreview() {
    ComposeTestingTheme {
        FrameLayoutExample()
    }
}