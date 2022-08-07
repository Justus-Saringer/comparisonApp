package com.example.composetesting.bars.bottomappbar

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.composetesting.ui.theme.ComposeTestingTheme

class BottomAppBarComposeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTestingTheme {
                BottomAppBarExample()
            }
        }
    }
}

sealed class BottomBarScreen(
    val title: String,
    val icon: ImageVector
) {
    object FirstScreen : BottomBarScreen(
        title = "FirstScreen",
        icon = Icons.Default.Favorite
    )

    object SecondScreen : BottomBarScreen(
        title = "SecondScreen",
        icon = Icons.Default.Search
    )
}

@Composable
private fun BottomAppBarExample() {

    val screens = listOf(
        BottomBarScreen.FirstScreen,
        BottomBarScreen.SecondScreen
    )

    var currentScreen by remember { mutableStateOf<BottomBarScreen>(BottomBarScreen.FirstScreen) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "BottomAppBar")
                }
            )
        },
        bottomBar = {
            BottomAppBarDetails(screens, currentScreen) { screen ->
                currentScreen = screen
            }
        }
    ) {
        when (currentScreen) {
            BottomBarScreen.FirstScreen -> FirstScreen()
            BottomBarScreen.SecondScreen -> SecondScreen()
        }
    }
}

@Composable
private fun BottomAppBarDetails(
    screens: List<BottomBarScreen>,
    currentScreen: BottomBarScreen,
    onClick : (BottomBarScreen) -> Unit
) {
    BottomAppBar(cutoutShape = CircleShape) {
        screens.forEach { screen ->
            BottomNavigationItem(
                label = { Text(text = screen.title) },
                icon = {
                    Icon(
                        imageVector = screen.icon,
                        contentDescription = "Navigation Icon"
                    )
                },
                selected = screen == currentScreen,
                onClick = {
                    onClick(screen)
                },
                alwaysShowLabel = false
            )
        }
    }
}