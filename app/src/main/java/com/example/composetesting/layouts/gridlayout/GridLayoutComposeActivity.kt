package com.example.composetesting.layouts.gridlayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composetesting.ui.theme.BlueBell
import com.example.composetesting.ui.theme.ComposeTestingTheme

class GridLayoutComposeActivity : ComponentActivity() {
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
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            GridLayoutExample()
                        }
                    }
                )
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun GridLayoutExample() {
    val colorList = listOf(
        BlueBell,
        Color.Cyan,
        Color(0xFFBB86FC),
        Color(0xFF3700B3)
    )

    LazyVerticalGrid(
        cells = GridCells.Fixed(2),
        modifier = Modifier.size(200.dp)
    ) {
        colorList.forEach {
            item {
                Box(
                    modifier = Modifier
                        .size(100.dp)
                        .background(it)
                )
            }
        }
    }
}

@Preview
@Composable
fun GridLayoutExamplePreview() {
    ComposeTestingTheme {
        GridLayoutExample()
    }
}