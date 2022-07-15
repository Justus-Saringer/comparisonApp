package com.example.composetesting.comparebutton

import android.content.Context
import android.content.Intent
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.HelpOutline
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composetesting.ui.theme.ComposeTestingTheme

@Composable
fun ComposeButtonRow(
    modifier: Modifier = Modifier,
    context: Context? = null,
    composeActivity: Class<out ComponentActivity>? = null,
    composeTitle: String,
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
            onClick = { context?.startActivity(Intent(context, composeActivity)) },
            colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primaryVariant)
        ) {
            Text(text = composeTitle)
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
fun ButtonRowPreview() {

    ComposeTestingTheme {
        ComposeButtonRow(composeTitle = "Compose") { }
    }
}