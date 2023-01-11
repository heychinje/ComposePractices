package com.telenav.composepractices.samples.screens.effect

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.telenav.composepractices.effects.linearGradient
import com.telenav.composepractices.samples.constants.SAMPLE_LINEAR_GRADIENT
import com.telenav.composepractices.samples.constants.SampleName
import com.telenav.composepractices.samples.screens.RootScreen

private val colorStops = arrayOf(
    0f to Color(0xFFFF0000), 0.5f to Color(0xFF00FF00), 1f to Color(0xFF0000FF)
)
private val textColor = Color(0xFF000000)

@Composable
fun LinearGradientScreen(
    onBackClick: (@SampleName String) -> Unit
) {
    RootScreen(
        screenName = SAMPLE_LINEAR_GRADIENT,
        onBackClick = { onBackClick(SAMPLE_LINEAR_GRADIENT) }) {
        val scrollState = rememberScrollState()
        Row(
            modifier = Modifier.horizontalScroll(scrollState)
        ) {
            listOf(
                0.0, 35.0, 90.0, 135.0, 180.0, 225.0, 270.0, 315.0, 360.0
            ).forEach {
                Box(
                    modifier = Modifier
                        .size(400.dp)
                        .linearGradient(
                            colorStops = colorStops, degrees = it.toDouble()
                        ),
                ) {
                    Text(
                        text = "$it", fontSize = 40.sp, color = textColor
                    )
                }
            }
        }
    }
}