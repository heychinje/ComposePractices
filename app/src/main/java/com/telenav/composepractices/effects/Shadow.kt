package com.telenav.composepractices.effects

import android.graphics.BlurMaskFilter
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.DrawModifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.ContentDrawScope
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas

fun Modifier.shadow(
    color: Color = Color(0xFF000000),
    offset: Offset = Offset.Zero,
    blurRadius: Float = 0.0f,
    spreadRadius: Float = 0.0f,
    shape: Shape = RectangleShape
) = this.then(
    ShadowModifier(color, offset, blurRadius, spreadRadius, shape)
)

private class ShadowModifier(
    val shadowColor: Color,
    val offset: Offset,
    val blurRadius: Float,
    val spreadRadius: Float,
    val shape: Shape
) : DrawModifier {

    override fun ContentDrawScope.draw() {
        drawIntoCanvas { canvas ->
            val paint = Paint().apply {
                color = shadowColor
                asFrameworkPaint().apply {
                    maskFilter = BlurMaskFilter(
                        blurRadius, BlurMaskFilter.Blur.NORMAL
                    )
                }
            }
            shape.createOutline(
                size, layoutDirection, this
            ).let { outline ->
                canvas.drawWithOffset(offset) {
                    when (outline) {
                        is Outline.Rectangle -> {
                            drawRect(outline.rect, paint)
                        }
                        is Outline.Rounded -> {
                            drawPath(
                                Path().apply { addRoundRect(outline.roundRect) }, paint
                            )
                        }
                        is Outline.Generic -> {
                            drawPath(outline.path, paint)
                        }
                    }
                }
            }
        }
        drawContent()
    }

    private fun Canvas.drawWithOffset(
        offset: Offset, block: Canvas.() -> Unit
    ) {
        save()
        translate(offset.x, offset.y)
        block()
        restore()
    }
}