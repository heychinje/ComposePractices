package com.telenav.composepractices.examples

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.telenav.composepractices.widgets.ListComposable

@Composable
fun ListComposableTest() {
    val items = listOf(
        "Sunday" to Color(0xFFF44336),
        "Monday" to Color(0xFFFF9800),
        "Tuesday" to Color(0xFFFFEB3B),
        "Wednesday" to Color(0xFF4CAF50),
        "Thursday" to Color(0xFF2196F3),
        "Friday" to Color(0xFF009688),
        "Saturday" to Color(0xFF9C27B0),
    )

    ListComposable(items) { DefaultWeekCard(item = it) }
}

@Composable
fun LazyRowTest() {
    val items = listOf(
        "Sunday" to Color(0xFFF44336),
        "Monday" to Color(0xFFFF9800),
        "Tuesday" to Color(0xFFFFEB3B),
        "Wednesday" to Color(0xFF4CAF50),
        "Thursday" to Color(0xFF2196F3),
        "Friday" to Color(0xFF009688),
        "Saturday" to Color(0xFF9C27B0),
    )

    LazyRow {
        items(items) { DefaultWeekCard(it) }
    }
}

@Composable
fun DefaultWeekCard(
    item: Pair<String, Color>
) {
    Text(
        text = item.first,
        style = MaterialTheme.typography.h5,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .background(androidx.compose.ui.graphics.Color.LightGray)
            .padding(10.dp)
            .size(250.dp)
            .background(item.second)
    )
}