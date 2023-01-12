package com.telenav.composepractices.samples.screens.effect

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.telenav.composepractices.effects.linearGradient
import com.telenav.composepractices.samples.EFFECT_SAMPLE_LINEAR_GRADIENT
import com.telenav.composepractices.samples.SampleName
import com.telenav.composepractices.samples.screens.RootScreen

private val colorStops = arrayOf(
    0f to Color(0xFFFF0000), 0.5f to Color(0xFF00FF00), 1f to Color(0xFF0000FF)
)
private val textColor = Color(0xFF000000)

@Composable
fun LinearGradientScreen(onBackClick: (@SampleName String) -> Unit) {
    RootScreen(screenName = EFFECT_SAMPLE_LINEAR_GRADIENT,
        onBackClick = { onBackClick(EFFECT_SAMPLE_LINEAR_GRADIENT) }) {
        val scrollState = rememberScrollState()
        val size = 300.dp
        Column{
            Row(
                modifier = Modifier
                    .padding(10.dp)
                    .horizontalScroll(scrollState)
            ) {
                for (i in 0..120 step 24) {
                    Box(
                        modifier = Modifier
                            .size(size)
                            .linearGradient(colorStops = colorStops, degrees = i.toDouble()),
                    ) {
                        Text(
                            text = "$i", fontSize = 40.sp, color = textColor
                        )
                    }
                }
            }

            Row(
                modifier = Modifier
                    .padding(10.dp)
                    .horizontalScroll(scrollState)
            ) {
                for (i in 144..264 step 24) {
                    Box(
                        modifier = Modifier
                            .size(size)
                            .linearGradient(colorStops = colorStops, degrees = i.toDouble()),
                    ) {
                        Text(
                            text = "$i", fontSize = 40.sp, color = textColor
                        )
                    }
                }
            }

            Row(
                modifier = Modifier
                    .padding(10.dp)
                    .horizontalScroll(scrollState)
            ) {
                for (i in 288..360 step 24) {
                    Box(
                        modifier = Modifier
                            .size(size)
                            .linearGradient(colorStops = colorStops, degrees = i.toDouble()),
                    ) {
                        Text(
                            text = "$i", fontSize = 40.sp, color = textColor
                        )
                    }
                }
            }
        }
    }
}