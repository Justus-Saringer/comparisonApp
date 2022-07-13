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
    composeCodeClick: ((String) -> Unit)? = null,
    viewCodeClick: ((String) -> Unit)? = null
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
                .padding(start = 18.dp, bottom = 4.dp, top = 4.dp)
                .fillMaxWidth()
                .align(Alignment.Start),
            text = title,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.h5
        )

        CompareButtonRow(
            context = context,
            composeActivity = composeActivity,
            androidViewActivity = androidViewActivity,
            composeTitle = composeTitle,
            viewTitle = viewTitle
        )



        Divider(
            modifier = Modifier.padding(horizontal = 16.dp),
            thickness = 2.dp
        )
    }
}

@Preview
@Composable
fun CompareButtonPreview() {
    ComposeTestingTheme {
        CompareItem(title = "ConstraintLayout",)
    }
}