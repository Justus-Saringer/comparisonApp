package com.example.composetesting.comparebutton

import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composetesting.ui.theme.ComposeTestingTheme

@Composable
fun CompareItem(
    modifier: Modifier = Modifier,
    composeActivity: Class<out ComponentActivity>? = null,
    androidViewActivity: Class<out AppCompatActivity>? = null,
    title: String,
    backgroundColor: Color = Color.Unspecified,
    composeTitle: String = "Compose",
    viewTitle: String = "Android View",
    composeCodeClick: (() -> Unit)? = null,
    viewCodeClick: (() -> Unit)? = null
) {

    val context = LocalContext.current

    Column(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(backgroundColor),
    ) {
        // title
        Text(
            modifier = Modifier
                .padding(start = 18.dp, bottom = 4.dp, top = 8.dp)
                .fillMaxWidth()
                .align(Alignment.Start),
            text = title,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.h5
        )

        ComposeButtonRow(
            modifier = Modifier.padding(vertical = 4.dp),
            context = context,
            composeActivity = composeActivity,
            composeTitle = composeTitle,
            onIconClick = { composeCodeClick?.invoke() }
        )

        ViewButtonRow(
            modifier = Modifier.padding(vertical = 4.dp),
            context = context,
            androidViewActivity = androidViewActivity,
            viewTitle = viewTitle,
            onIconClick = { viewCodeClick?.invoke() }
        )

        Divider(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
            thickness = 2.dp
        )
    }
}

@Preview
@Composable
fun CompareButtonPreview() {
    ComposeTestingTheme {
        CompareItem(title = "ConstraintLayout")
    }
}