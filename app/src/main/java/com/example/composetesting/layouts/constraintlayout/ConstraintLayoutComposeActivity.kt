package com.example.composetesting.layouts.constraintlayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.composetesting.ui.theme.*


class ConstraintLayoutComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeTestingTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(text = "ConstraintLayout")
                            },
                            backgroundColor = MaterialTheme.colors.primary
                        )
                    }, content = {
                        ConstraintLayoutExample()
                    }
                )
            }
        }
    }
}

@Composable
private fun ConstraintLayoutExample() {
    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        val (purple, orange, blue, green, leftView, middleView, rightView) = createRefs()

        Text(
            textAlign = TextAlign.Center,
            text = "constraint to start, top and end of parent with a horizontal bias of 30/70",
            modifier = Modifier
                .padding(top = 80.dp)
                .width(150.dp)
                .background(Purple200)
                .padding(10.dp)
                .constrainAs(purple) {
                    linkTo(
                        parent.start,
                        parent.end,
                        bias = 0.3F
                    )
                }
        )

        Text(
            textAlign = TextAlign.Center,
            text = "constraint via circle radius(170dp) and angle(135) to purple",
            modifier = Modifier
                .width(180.dp)
                .background(Orange200)
                .padding(10.dp)
                .constrainAs(orange) {
                    circular(purple, angle = 135F, distance = 170.dp)
                }
        )

        Text(
            textAlign = TextAlign.Center,
            text = "Chain A, both are bi-directional connected",
            modifier = Modifier
                .width(120.dp)
                .background(Green200)
                .padding(10.dp)
                .constrainAs(green) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                }
        )

        Text(
            text = "Chain B, and chained with chainStyle \"Spread\"",
            modifier = Modifier
                .width(120.dp)
                .background(Blue200)
                .padding(10.dp)
                .constrainAs(blue) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                },
            textAlign = TextAlign.Center
        )

        Text(
            text = "chained with 30 percent",
            modifier = Modifier
                .background(Red200)
                .height(60.dp)
                .padding(10.dp)
                .constrainAs(leftView) {
                    bottom.linkTo(parent.bottom)
                    width = Dimension.percent(0.3F)
                },
            textAlign = TextAlign.Center
        )

        Text(
            text = "chained with 40 percent",
            modifier = Modifier
                .background(Color.Gray)
                .height(60.dp)
                .padding(10.dp)
                .constrainAs(middleView) {
                    bottom.linkTo(parent.bottom)
                    width = Dimension.percent(0.4F)
                },
            textAlign = TextAlign.Center
        )

        Text(
            textAlign = TextAlign.Center,
            text = "chained with 30 percent",
            modifier = Modifier
                .background(Color.Cyan)
                .height(60.dp)
                .padding(10.dp)
                .constrainAs(rightView) {
                    bottom.linkTo(parent.bottom)
                    width = Dimension.percent(0.3F)
                }
        )

        val chainRefOne = createHorizontalChain(green, blue, chainStyle = ChainStyle.Spread)
        val chainRefTwo = createHorizontalChain(leftView, middleView, rightView, chainStyle = ChainStyle.Spread)
    }
}

@Preview(showBackground = true, device = Devices.NEXUS_6, showSystemUi = true)
@Composable
private fun ConstraintLayoutExamplePreview() {
    MaterialTheme {
        ConstraintLayoutExample()
    }
}