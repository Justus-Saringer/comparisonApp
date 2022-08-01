package com.example.composetesting.more.custom


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composetesting.R
import com.example.composetesting.ui.theme.ComposeTestingTheme
import kotlin.text.Typography.bullet

class CustomViewComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeTestingTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(text = "CustomView")
                            },
                            backgroundColor = MaterialTheme.colors.primary
                        )
                    }, content = {
                        CustomViewExample(
                            title = "Hello World",
                            textList = listOf(
                                "This is a bullet",
                                "This is a another bullet",
                                "This is a another bullet"
                            )
                        )
                    }
                )
            }
        }
    }
}

@Composable
fun CustomViewExample(
    modifier: Modifier = Modifier,
    title: String,
    image: Painter? = null,
    textList: List<String>
) {
    Card(
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth(),
        elevation = 6.dp
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = title,
                    textAlign = TextAlign.Start,
                    style = MaterialTheme.typography.h4
                )

                Image(
                    modifier = Modifier.size(24.dp),
                    painter = image ?: painterResource(id = R.drawable.ic_baseline_favorite_24),
                    contentDescription = null
                )
            }

            textList.forEach {
                Text(text = "$bullet $it")
            }
        }
    }
}

@Preview
@Composable
fun CustomViewExamplePreview() {
    ComposeTestingTheme {
        CustomViewExample(
            title = "This is a title",
            textList = listOf(
                "This is a bullet",
                "This is a another bullet",
                "This is a another bullet"
            )
        )
    }
}