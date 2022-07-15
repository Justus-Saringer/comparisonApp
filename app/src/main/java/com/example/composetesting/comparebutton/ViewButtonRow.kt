package com.example.composetesting.comparebutton

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Games
import androidx.compose.material.icons.filled.QuestionAnswer
import androidx.compose.material.icons.outlined.HelpOutline
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composetesting.ui.theme.ComposeTestingTheme

@Composable
fun ViewButtonRow(
    modifier: Modifier = Modifier,
    context: Context? = null,
    androidViewActivity: Class<out AppCompatActivity>? = null,
    viewTitle: String,
    onIconClick: () -> Unit
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Button(
            modifier = Modifier
                .padding(horizontal = 18.dp)
                .clip(RoundedCornerShape(10.dp))
                .width(150.dp)
                .height(56.dp),
            onClick = { context?.startActivity(Intent(context, androidViewActivity)) },
            colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primaryVariant)
        ) {
            Text(text = viewTitle)
        }
        
        IconButton(onClick = onIconClick) {
            Icon(
                modifier = Modifier
                    .padding(end = 24.dp)
                    .size(48.dp),
                imageVector = Icons.Outlined.HelpOutline,
                contentDescription = null
            )
        }
    }
}

@Preview
@Composable
fun ViewButtonRowPreview() {
    ComposeTestingTheme {
        ViewButtonRow(viewTitle = "View") { }
    }
}