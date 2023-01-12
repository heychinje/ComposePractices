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

private val shadowColor1 = Color.Red
private const val shadowBlur1 = blur
private val shadowOffset1 = Offset(-20F, -20F)

private val shadowColor2 = Color.Green
private const val shadowBlur2 = blur
private val shadowOffset2 = Offset(20F, 20F)


@Composable
fun IrregularShadow() {
    Box(
        modifier = Modifier.padding(padding.dp)
    ) {
        val path = Path().apply {
            moveTo(0f, 0f)
            lineTo(size / 2, 0f)
            addArc(Rect(0f, 0f, size, size), -90f, 270f)
            lineTo(0f, 0f)
            close()
        }
        val shape = GenericShape() { _, _ -> addPath(path) }
        Canvas(
            modifier = Modifier
                .size(size.dp)
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
        ) {
            drawPath(path, color)
        }
    }
}