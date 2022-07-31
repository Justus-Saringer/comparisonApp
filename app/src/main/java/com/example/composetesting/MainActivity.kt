package com.example.composetesting

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.GridItemSpan
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composetesting.bars.BarsActivity
import com.example.composetesting.buttonsandtexts.ButtonsAndTextsActivity
import com.example.composetesting.layouts.LayoutActivity
import com.example.composetesting.recyclerviewandcolumns.RecyclerViewAndColumnsActivity
import com.example.composetesting.ui.theme.ComposeTestingTheme

// TODO: turn off rotation and horizontal mode

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTestingTheme {
                MainScreen()
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainScreen() {

    val scrollState = rememberLazyListState()

    // buttons
    LazyVerticalGrid(
        modifier = Modifier
            .fillMaxSize()
            .scrollable(scrollState, Orientation.Vertical)
            .background(MaterialTheme.colors.background),
        cells = GridCells.Adaptive(132.dp),
        state = scrollState,
        contentPadding = PaddingValues(16.dp)
    ) {

        // title
        item(span = { GridItemSpan(2) }) {
            Text(
                modifier = Modifier
                    .padding(bottom = 32.dp)
                    .fillParentMaxWidth(),
                textAlign = TextAlign.Center,
                text = "Jetpack Compose",
                style = MaterialTheme.typography.h4
            )
        }

        item {
            StartButton(
                composeActivity = LayoutActivity::class.java,
                buttonText = "Layouts",
                backgroundColor = MaterialTheme.colors.secondary
            )
        }

        item {
            StartButton(
                composeActivity = ButtonsAndTextsActivity::class.java,
                buttonText = "Buttons\nand\nTexts",
                backgroundColor = MaterialTheme.colors.secondary
            )
        }

        item {
            StartButton(
                composeActivity = BarsActivity::class.java,
                buttonText = "Bars",
                backgroundColor = MaterialTheme.colors.secondary
            )
        }

        item {
            StartButton(
                composeActivity = RecyclerViewAndColumnsActivity::class.java,
                buttonText = "RecyclerViews\nColumns",
                backgroundColor = MaterialTheme.colors.secondary
            )
        }

        item {
            StartButton(
                composeActivity = null,
                buttonText = "Navigation",
                backgroundColor = MaterialTheme.colors.secondary
            )
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    device = Devices.PIXEL_4,
    backgroundColor = 0xFFFFFFFF
)
@Composable
fun DefaultPreview() {
    ComposeTestingTheme {
        MainScreen()
    }
}