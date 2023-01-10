package com.telenav.composepractices.samples.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val textColor = Color(0xFF000000)

@Composable
fun WeekCard(
    item: Pair<String, Color>
) {
    Box(
        modifier = Modifier
            .padding(10.dp)
            .size(250.dp)
            .background(item.second),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = item.first,
            fontSize = 32.sp,
            color = textColor,
            textAlign = TextAlign.Center,
        )
    }
}