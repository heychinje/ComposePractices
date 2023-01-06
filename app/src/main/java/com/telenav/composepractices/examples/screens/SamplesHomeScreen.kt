package com.telenav.composepractices.examples.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SamplesHomeScreen() {
    val screens = remember {
        listOf("LazyColumnEdgeFade", "LazyColumnEdgeFade2", "LazyColumnEdgeFade3")
    }
    LazyRow {
        items(screens) { screen ->
            Text(
                text = screen,
                fontSize = 36.sp,
                modifier = Modifier
                    .size(250.dp)
                    .background(Color.LightGray)
            )
        }
    }
}