package com.example.composetesting

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun StartButton(
    modifier: Modifier = Modifier,
    composeActivity: Class<out AppCompatActivity>? = null,
    buttonText: String,
    buttonHight: Dp = 100.dp,
    backgroundColor: Color,
) {

    val context = LocalContext.current

    Box(
        modifier = modifier
            .padding(8.dp)
            .shadow(8.dp)
            .clip(RoundedCornerShape(8.dp))
            .clickable {
                context.startActivity(Intent(context, composeActivity))
            }
            .height(buttonHight)
            .background(backgroundColor),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = buttonText,
            fontSize = 22.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Preview
@Composable
fun StartButtonPreview() {
    MaterialTheme {
        StartButton(buttonText = "ButtonText", backgroundColor = MaterialTheme.colors.onBackground)
    }
}