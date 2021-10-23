package com.aniruddha.kudalkar.livestreamapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            var red by remember { mutableStateOf(0.5f) }
            var green by remember { mutableStateOf(0.5f) }
            var blue by remember { mutableStateOf(0.5f) }

            Column {
                Row(
                    modifier = Modifier
                        .weight(0.5f)
                ) {
                    ColorPresenter(red, green, blue)
                }
                Row(
                    modifier = Modifier
                        .weight(0.5f)
                ) {
                    ColorChooser { r, g, b ->
                        red = r
                        green = g
                        blue = b
                    }
                }
            }
        }
    }
}

@Composable
fun ColorSlider(
    label: String,
    onSlide: (Float) -> Unit
) {
    var slideValue by remember { mutableStateOf(0.5f) }

    Row(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp)
    ) {
        Column {
            Text(
                text = label,
                fontSize = 24.sp
            )
            Slider(
                value = slideValue,
                onValueChange = {
                    slideValue = it
                    onSlide(slideValue)
                }
            )
        }
    }
}

@Composable
fun ColorPresenter(
    red: Float,
    green: Float,
    blue: Float
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(
                Color(red, green, blue)
            )
    ) {

    }
}

@Composable
fun ColorChooser(
    onColorChange: (Float, Float, Float) -> Unit
) {
    var red by remember { mutableStateOf(0.5f) }
    var green by remember { mutableStateOf(0.5f) }
    var blue by remember { mutableStateOf(0.5f) }

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(),

        verticalArrangement = Arrangement.SpaceEvenly

    ) {

        ColorSlider(label = "Red", onSlide = {
            red = it
            onColorChange(red, green, blue)
        })
        ColorSlider(label = "Green", onSlide = {
            green = it
            onColorChange(red, green, blue)
        })
        ColorSlider(label = "Blue", onSlide = {
            blue = it
            onColorChange(red, green, blue)
        })
    }
}


