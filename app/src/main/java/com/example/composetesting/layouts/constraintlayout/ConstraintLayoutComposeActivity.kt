package com.example.composetesting.layouts.constraintlayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Cyan
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class ConstraintLayoutComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(text = "ConstraintLayout")
                            },
                            navigationIcon = {
                                IconButton(onClick = { onBackPressed() }) {
                                    Icon(
                                        imageVector = Icons.Default.ArrowBack,
                                        contentDescription = null
                                    )
                                }
                            }
                        )
                    }, content = {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            ConstraintLayoutExample()
                        }
                    }
                )
            }
        }
    }
}

@Composable
private fun ConstraintLayoutExample() {
    Box(modifier = Modifier
        .size(100.dp)
        .background(Cyan))
}

@Preview(showBackground = true, device = Devices.NEXUS_6, showSystemUi = true)
@Composable
private fun ConstraintLayoutExamplePreview() {
    MaterialTheme {
        ConstraintLayoutExample()
    }
}