package com.example.composetesting.layouts

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.example.composetesting.CompareButton
import com.example.composetesting.layouts.constraintlayout.ConstraintLayoutComposeActivity
import com.example.composetesting.layouts.constraintlayout.ConstraintLayoutViewActivity
import com.example.composetesting.ui.theme.ComposeTestingTheme

class LayoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeTestingTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = { Text(text = "Layouts") },
                            backgroundColor = MaterialTheme.colors.primary,
                            contentColor = MaterialTheme.colors.onPrimary
                        )
                    }
                ) {
                    LayoutScreen()
                }
            }
        }
    }
}

@Composable
private fun LayoutScreen() {
    CompareButton(
        title = "ConstraintLayout",
        composeActivity = ConstraintLayoutComposeActivity::class.java,
        androidViewActivity = ConstraintLayoutViewActivity::class.java
    )
}

@Preview(showBackground = true, showSystemUi = false, device = Devices.PIXEL_4)
@Composable
private fun LayoutScreenPreview() {
    MaterialTheme {
        LayoutScreen()
    }
}



