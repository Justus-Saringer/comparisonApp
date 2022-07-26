package com.example.composetesting.bars.toolbar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import com.example.composetesting.ui.theme.ComposeTestingTheme

class ToolbarComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeTestingTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(text = "Toolbar")
                            },
                            backgroundColor = MaterialTheme.colors.primary,
                            navigationIcon = {
                                IconButton(
                                    onClick = { onBackPressed() }
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.ArrowBack,
                                        contentDescription = null
                                    )
                                }
                            },
                            actions = {
                                IconButton(
                                    onClick = { }
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Favorite,
                                        contentDescription = null
                                    )
                                }
                            }
                        )
                    },
                    content = {

                    }
                )
            }
        }
    }
}