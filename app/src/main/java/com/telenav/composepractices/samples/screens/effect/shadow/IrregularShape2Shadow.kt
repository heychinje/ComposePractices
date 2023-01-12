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
fun Irregular2Shadow() {
    Box(
        modifier = Modifier.padding(padding.dp)
    ) {
        val path = Path().apply {
            moveTo(size / 10, size / 2)
            cubicTo(size / 3, size / 5*2,size / 5, size / 2, size / 2, size / 2)
            cubicTo(size / 2, size / 4 * 3, size / 3 * 2, size / 4 * 3, size / 10 * 9, size / 2)
            quadraticBezierTo(size / 10 * 9, size / 2, size / 10 * 9, size / 4 * 3)
            quadraticBezierTo(size, size / 3*2, size / 10 * 7, size)
            quadraticBezierTo(size / 2, size, size / 4, size / 10 * 7)
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