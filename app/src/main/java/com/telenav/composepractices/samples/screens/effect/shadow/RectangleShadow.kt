package com.telenav.composepractices.samples.screens.effect.shadow

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.telenav.composepractices.effects.shadow

private val shadowColor1 = Color.Red
private const val shadowBlur1 = blur
private val shadowOffset1 = Offset(-20F, -20F)

private val shadowColor2 = Color.Green
private const val shadowBlur2 = blur
private val shadowOffset2 = Offset(20F, 20F)


@Composable
fun RectangleShadow() {
    Box(
        modifier = Modifier.padding(padding.dp)
    ) {
        val modifier = Modifier.size(size.dp)
        Canvas(
            modifier = modifier
                .shadow(
                    color = shadowColor1,
                    offset = shadowOffset1,
                    blurRadius = shadowBlur1,
                )
                .shadow(
                    color = shadowColor2,
                    offset = shadowOffset2,
                    blurRadius = shadowBlur2,
                )
        ) {
            drawRect(Color.LightGray)
        }
    }
}