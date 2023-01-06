package com.telenav.composepractices.effects

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.Orientation.Horizontal
import androidx.compose.foundation.gestures.Orientation.Vertical
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.unit.LayoutDirection

/**
 * A modifier that draws a linear gradient fade effect on the edge of the content. Currently this
 * fade effect supported for [Column], [Text] and [LazyColumn]
 *
 * @param orientation the orientation of the gradient fade effect, [Orientation.Horizontal] or [Orientation.Vertical].
 * @param colorStops the color stops of the gradient fade effect, from the start of the viewport
 * area to the end of the viewport
 * @param blendMode the blendMode between the effect layer and the real viewport layer.
 * [BlendMode], refer to [https://developer.android.com/reference/android/graphics/BlendMode]
 * @param contentOffset the offset of the content area(viewport area), the default value is 0.
 * @param scrolledOffset
 * @IMPORTANT If we can make sure that the drawing effect area is always NOT changeable, then we
 * can ignore this parameter, like we using the fade effect on [LazyColumn] or [Text]. But if we
 * apply this fade effect on [Column], we need change the drawing area manually when the content
 * is scrolling. Otherwise the fade effect will always draw on the start of the [Components]. In
 * order to match the design, calculating the drawing area dynamically is necessary based on the
 * scrolled offset.
 *
 * @param viewportOffset
 * @IMPORTANT Normally if we use the fade effect on [LazyColumn] or [Text], the viewport of the
 * [LazyColumn] always equals to the the [DrawScope.size]. So we can ignore this parameter. But
 * if we use the fade effect on [Column], the viewport of the [Column] has TWO parts: the one is
 * the viewport size of the [Column], the another is the size of invisible area of the [Column],
 * which area can be scrolled to the visible area. In order to always draw the fade effectSo on
 * the visible area(viewport), so we NEED to pass this parameter to change the drawing area.
 * [Column], the viewport of the [Column] is changeable. We should use this parameter to calculate
 *
 * @param isEnabled whether display the fade effect
 */
fun Modifier.linearFade(
    orientation: Orientation,
    isEnabled: Boolean,
    layoutDirection: LayoutDirection = LayoutDirection.Ltr,
    colorStops: Array<Pair<Float, Color>>,
    blendMode: BlendMode = BlendMode.DstIn,
    contentOffset: Offset = Offset.Zero,
    scrolledOffset: Int? = null,
    viewportOffset: Int? = null,
) = if (isEnabled) {
    drawWithContent {
        drawIntoCanvas {
            it.withSaveLayer(Rect(contentOffset, size), Paint()) {
                // real content
                drawContent()

                val viewportSize = when (orientation) {
                    Horizontal -> size.width - (viewportOffset ?: 0)
                    Vertical -> size.height - (viewportOffset ?: 0)
                }

                val scrolledOffSize = (scrolledOffset ?: 0).toFloat()

                val (start, end) = when (orientation) {
                    Horizontal -> when (layoutDirection) {
                        LayoutDirection.Ltr -> Offset(scrolledOffSize, 0F) to Offset(scrolledOffSize + viewportSize, 0F)
                        LayoutDirection.Rtl -> Offset(scrolledOffSize + viewportSize, 0F) to Offset(scrolledOffSize, 0F)
                    }
                    Vertical -> Offset(0F, scrolledOffSize) to Offset(0F, scrolledOffSize + viewportSize)
                }

                drawRect(
                    brush = Brush.linearGradient(
                        colorStops = colorStops,
                        start = start,
                        end = end
                    ), blendMode = blendMode
                )
            }
        }
    }
} else this
