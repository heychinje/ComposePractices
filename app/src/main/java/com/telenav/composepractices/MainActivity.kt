package com.telenav.composepractices

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.telenav.composepractices.ui.theme.ComposePracticesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            // There are 3 sample ways to arrange UI elements: Column, Row, and Box
            // Column: place items vertically on the screen
            // Row: place items horizontally on the screen
            // Box: place items on the top of each other
            Column(
                modifier = Modifier
                    .background(color = Color.LightGray)
                    .fillMaxSize(0.5f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Greeting("AB")
                Greeting("CDEF")
                Greeting("G")
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(
        text = "Hello $name!",
        fontSize = 32.sp,
        color = Color.Red,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .background(color = Color.Yellow)
            .border(2.dp, color = Color.Blue)
            .padding(10.dp)
            .border(2.dp, color = Color.Magenta)
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposePracticesTheme {
        Greeting("Android")
    }
}