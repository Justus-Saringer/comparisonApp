package com.example.composetesting

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RowWithTwoButtons(
    composeActivity1: Class<out AppCompatActivity>,
    composeActivity2: Class<out AppCompatActivity>,
    buttonText1: String,
    buttonText2: String,
    backgroundColor: Color,
) {

    val context = LocalContext.current

    Row(
        modifier = Modifier
            .padding(vertical = 8.dp)
            .fillMaxWidth()
            .height(108.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Box(
            modifier = Modifier
                .shadow(8.dp)
                .clickable {
                    context.startActivity(Intent(context, composeActivity1))
                }
                .clip(RoundedCornerShape(8.dp))
                .fillMaxHeight()
                .background(backgroundColor)
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .padding(horizontal = 16.dp),
            contentAlignment = Alignment.Center,
        ) {
            Text(
                text = buttonText1,
                fontSize = 22.sp
            )
        }

        Box(
            modifier = Modifier
                .shadow(8.dp)
                .clickable {
                    context.startActivity(Intent(context, composeActivity2))
                }
                .clip(RoundedCornerShape(8.dp))
                .fillMaxHeight()
                .background(backgroundColor)
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .padding(horizontal = 16.dp),
            contentAlignment = Alignment.Center,
        ) {
            Text(
                text = buttonText2,
                fontSize = 22.sp
            )
        }
    }

}