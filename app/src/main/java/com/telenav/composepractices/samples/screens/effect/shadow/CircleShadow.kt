package com.telenav.composepractices.samples.screens.effect.shadow

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.unit.dp
import com.telenav.composepractices.effects.shadow

const val padding = 20F
const val size = 400F
const val blur = 50F
val color = Color.LightGray

private val shadowColor1 = Color.Red
private val shadowBlur1 = blur
private val shadowOffset1 = Offset(0F, -20F)

private val shadowColor2 = Color.Green
private val shadowBlur2 = blur
private val shadowOffset2 = Offset(-17.32F, 10F)

private val shadowColor3 = Color.Blue
private val shadowBlur3 = blur
private val shadowOffset3 = Offset(17.32F, 20F)

@Composable
fun CircleShadow() {
    Box(
        modifier = Modifier.padding(padding.dp)
    ) {
        val modifier = Modifier.size(size.dp)
        val circlePath = Path().apply {
            moveTo(0F, 0F)
            addOval(Rect(0F, 0F, size, size))
            close()
        }
        val shape = GenericShape { _, _ -> addPath(circlePath) }
        Canvas(
            modifier = modifier
                .shadow(
                    color = shadowColor1,
                    offset = shadowOffset1,
                    blurRadius = shadowBlur1,
                    shape = shape
                )
                .shadow(
                    color = shadowColor2,
                    offset = shadowOffset2,
                    blurRadius = shadowBlur2,
                    shape = shape
                )
                .shadow(
                    color = shadowColor3,
                    offset = shadowOffset3,
                    blurRadius = shadowBlur3,
                    shape = shape
                )
        ) {
            drawPath(circlePath, color)
        }
    }
}