package com.example.composetesting.comparebutton

import android.content.Context
import android.content.Intent
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composetesting.ui.theme.ComposeTestingTheme

@Composable
fun CompareButtonRow(
    context: Context? = null,
    composeActivity: Class<out ComponentActivity>? = null,
    androidViewActivity: Class<out AppCompatActivity>? = null,
    composeTitle: String,
    viewTitle: String
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        // compose button
        Button(
            modifier = Modifier
                .width(200.dp)
                .padding(horizontal = 18.dp),
            onClick = { context?.startActivity(Intent(context, composeActivity)) },
            colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primaryVariant)
        ) {
            Text(text = composeTitle)
        }

        // android view button
        Button(
            modifier = Modifier
                .width(200.dp)
                .padding(horizontal = 18.dp),
            onClick = { context?.startActivity(Intent(context, androidViewActivity)) },
            colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primaryVariant)
        ) {
            Text(text = viewTitle)
        }
    }
}

@Preview
@Composable
fun ButtonRowPreview() {

    ComposeTestingTheme {
        CompareButtonRow(viewTitle = "View", composeTitle = "Compose")
    }
}