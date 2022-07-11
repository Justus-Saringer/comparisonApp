package com.example.composetesting.layouts

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.ui.viewinterop.AndroidViewBinding
import com.example.composetesting.R
import com.example.composetesting.databinding.Layout1Binding
import org.w3c.dom.Text

class LayoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = { Text(text = "Layouts") },
                            navigationIcon = {
                                Icon(
                                    imageVector = Icons.Default.ArrowBack,
                                    contentDescription = null
                                )
                            }
                        )
                    }
                ) {
                    LayoutScreen()
                }
            }
        }
    }
}

class Movie(id: Int, movieName: String) {
    var Id: Int = id
    var name: String = movieName
}

@Composable
private fun movieComposable(movie: Movie) {
    Text(text = movie.name)
}

@Composable
private fun LayoutScreen() {

    val movies = listOf(
        Movie(0, "hello"),
        Movie(1, "hello W"),
        Movie(2, "hello Wo"),
        Movie(3, "hello Wor"),
        Movie(4, "hello Worl"),
        Movie(5, "hello World")
    )

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        for (movie in movies) {
            key(movie.Id) {
                movieComposable(movie = movie)
            }
        }
    }

    var text by remember { mutableStateOf("Hello World")}

    /*AndroidViewBinding(
        modifier = Modifier,
        factory = Layout1Binding::inflate,
        update = {
            button.setOnClickListener {
                this.textView.text = "you clicked me!"
            }
        }
    )*/

    AndroidViewBinding(
        modifier = Modifier,
        factory = Layout1Binding::inflate,
        update = {
            val myFragment = fragmentContainerViewId.getFragment<MyFragment>()
        }
    )

    /*Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF5E5D5D)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .padding(32.dp)
                .background(Color.Cyan)
                .fillMaxWidth()
                .height(200.dp)
                .padding(32.dp)
                .background(Color.Red)
        )
    }*/
}

@Preview(showBackground = true, showSystemUi = false, device = Devices.PIXEL_4)
@Composable
private fun LayoutScreenPreview() {
    MaterialTheme {
        LayoutScreen()
    }
}



