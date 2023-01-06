package com.telenav.composepractices.components

import androidx.annotation.IntDef
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.*
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp

/**
 * @param color the color of the scroll bar, it must have alpha channel
 * @param bgColor the background color of the scroll bar, it must have alpha channel
 */
fun Modifier.scrollBar(
    maxScrollableOffset: Int,
    scrolledOffset: Int,
    orientation: Orientation,
    @Position position: Int,
    color: Color,
    bgColor: Color = Color.Transparent,
    strokeWidth: Dp = 8.dp,
    strokeCap: StrokeCap = StrokeCap.Round,
    bgStrokeCap: StrokeCap = StrokeCap.Round,
    blendMode: BlendMode = BlendMode.SrcOver,
    paddingStart: Dp = 0.dp,
    paddingTop: Dp = 0.dp,
    paddingEnd: Dp = 0.dp,
    paddingBottom: Dp = 0.dp,
    isEnabled: Boolean = true,
    layoutDirection: LayoutDirection = LayoutDirection.Ltr
) = scrollBar(
    maxScrollDistance = maxScrollableOffset,
    scrolledDistance = scrolledOffset,
    orientation = orientation,
    position = position,
    strokeWidth = strokeWidth,
    strokeCap = strokeCap,
    bgStrokeCap = bgStrokeCap,
    blendMode = blendMode,
    brush = SolidColor(color),
    bgBrush = SolidColor(bgColor),
    paddingStart = paddingStart,
    paddingTop = paddingTop,
    paddingEnd = paddingEnd,
    paddingBottom = paddingBottom,
    isEnabled = isEnabled,
    layoutDirection = layoutDirection
)

fun Modifier.scrollBar(
    maxScrollDistance: Int,
    scrolledDistance: Int,
    orientation: Orientation,
    @Position position: Int,
    brush: Brush,
    bgBrush: Brush = SolidColor(Color.Transparent),
    strokeWidth: Dp = 2.dp,
    strokeCap: StrokeCap = StrokeCap.Round,
    bgStrokeCap: StrokeCap = StrokeCap.Round,
    blendMode: BlendMode = BlendMode.SrcOver,
    paddingStart: Dp = 0.dp,
    paddingTop: Dp = 0.dp,
    paddingEnd: Dp = 0.dp,
    paddingBottom: Dp = 0.dp,
    isEnabled: Boolean = true,
    layoutDirection: LayoutDirection = LayoutDirection.Ltr
) = if (isEnabled) {
    drawWithContent {
        drawContent()

        // viewport sizes
        val viewportTotalLength = when (orientation) {
            Orientation.Vertical -> size.height
            Orientation.Horizontal -> size.width
        }
        val viewportVisibleSize = when (orientation) {
            Orientation.Vertical -> size.copy(height = size.height - maxScrollDistance)
            Orientation.Horizontal -> size.copy(width = size.width - maxScrollDistance)
        }

        // bar sizes
        val barRangeLength = when (orientation) {
            Orientation.Vertical -> viewportVisibleSize.height - paddingTop.toPx() - paddingBottom.toPx()
            Orientation.Horizontal -> viewportVisibleSize.width - paddingStart.toPx() - paddingEnd.toPx()
        }

        // the radio of the bar length to the viewport length
        val ratio = barRangeLength / viewportTotalLength
        val barMaxScrollableDistance = maxScrollDistance * ratio
        val (barLength, barWidth) = barRangeLength - barMaxScrollableDistance to strokeWidth.toPx()

        fun calculateBarPosition(
            orientation: Orientation,
            @Position position: Int,
            width: Float,
            height: Float,
            deltaLength: Float,
            barWidth: Float,
            paddingStart: Float,
            paddingTop: Float,
            paddingEnd: Float,
            paddingBottom: Float,
            layoutDirection: LayoutDirection
        ) = when (orientation) {
            Orientation.Vertical -> when (position) {
                START -> if (layoutDirection == LayoutDirection.Ltr)
                    Offset(
                        paddingStart, paddingTop
                    ) to Offset(
                        paddingStart, paddingTop + deltaLength
                    ) else {
                    Offset(
                        width - paddingStart - barWidth,
                        paddingTop
                    ) to Offset(
                        width - paddingStart - barWidth, paddingTop + deltaLength
                    )
                }
                END -> if (layoutDirection == LayoutDirection.Ltr) {
                    Offset(
                        width - paddingEnd - barWidth, paddingTop
                    ) to Offset(
                        width - paddingEnd - barWidth, paddingTop + deltaLength
                    )
                } else {
                    Offset(
                        paddingEnd + barWidth, paddingTop
                    ) to Offset(
                        paddingEnd + barWidth, paddingTop + deltaLength
                    )
                }
                else -> null to null
            }
            Orientation.Horizontal -> when (position) {
                TOP ->
                    if (layoutDirection == LayoutDirection.Ltr) {
                        Offset(
                            paddingStart, paddingTop
                        ) to Offset(
                            paddingStart + deltaLength, paddingTop
                        )
                    } else {
                        Offset(
                            paddingStart + deltaLength, paddingTop
                        ) to Offset(
                            paddingStart, paddingTop
                        )
                    }
                BOTTOM ->
                    if (layoutDirection == LayoutDirection.Ltr) {
                        Offset(
                            paddingStart, height - paddingBottom - barWidth
                        ) to Offset(
                            paddingStart + deltaLength, height - paddingBottom - barWidth
                        )
                    } else {
                        Offset(
                            paddingStart + deltaLength, height - paddingBottom - barWidth
                        ) to Offset(
                            paddingStart, height - paddingBottom - barWidth
                        )
                    }
                else -> null to null
            }
        }

        fun Offset.doScroll(distance: Float, orientation: Orientation) = when (orientation) {
            Orientation.Vertical -> copy(y = y + distance)
            Orientation.Horizontal -> copy(x = x + distance)
        }

        // calculate the background position
        calculateBarPosition(
            orientation = orientation,
            position = position,
            width = viewportVisibleSize.width,
            height = viewportVisibleSize.height,
            deltaLength = barRangeLength,
            barWidth = barWidth,
            paddingStart = paddingStart.toPx(),
            paddingTop = paddingTop.toPx(),
            paddingEnd = paddingEnd.toPx(),
            paddingBottom = paddingBottom.toPx(),
            layoutDirection = layoutDirection
        )
            .let {
                // draw the background
                val start = it.first ?: return@let
                val end = it.second ?: return@let

                /*
                The scrolled distance of the background should be equal to the viewport scrolled
                distance. Because it is invisible, we DO NOT need to map the viewport scrolled distance
                 to the scrollbar container. So we just use the viewport scrolled distance to fill
                 the gap of the coordinates system between the viewport and the screen to make sure
                 that the background DOES NOT move. It's NOT same with scrollbar which needs to map both
                 invisible area and visible area.
                 */
                val fixedScrolledDistance = scrolledDistance * 1.0F
                drawLine(
                    brush = bgBrush,
                    start = start.doScroll(fixedScrolledDistance, orientation),
                    end = end.doScroll(fixedScrolledDistance, orientation),
                    strokeWidth = barWidth,
                    cap = bgStrokeCap,
                    blendMode = blendMode
                )
            }

        // scrollbar position
        calculateBarPosition(
            orientation = orientation,
            position = position,
            width = viewportVisibleSize.width,
            height = viewportVisibleSize.height,
            deltaLength = barLength,
            barWidth = barWidth,
            paddingStart = paddingStart.toPx(),
            paddingTop = paddingTop.toPx(),
            paddingEnd = paddingEnd.toPx(),
            paddingBottom = paddingBottom.toPx(),
            layoutDirection = layoutDirection
        ).let {
            // draw the scrollbar
            val start = it.first ?: return@let
            val end = it.second ?: return@let

            /*
            The scrollbar scrolled distance should have TWO parts.
            Part 1: The invisible scrolled distance of the viewport, which is out of the screen
            distance, is to fill the gap between the coordinates system between the viewport and
            the screen.
            Part2: The indicated scrolled distance of scrollbar, is to indicate the screen
            scrolled distance. So we DO need to map the viewport scrolled distance to the
            scrollbar container.There is a ratio between the viewport and scrollbar container [ratio]
             */
            val fixedScrolledDistance = scrolledDistance * 1.0F + scrolledDistance * ratio
            drawLine(
                brush = brush,
                start = start.doScroll(fixedScrolledDistance, orientation),
                end = end.doScroll(fixedScrolledDistance, orientation),
                strokeWidth = barWidth,
                cap = strokeCap,
                blendMode = blendMode
            )
        }
    }
} else this

const val START = 0
const val END = 1
const val TOP = 2
const val BOTTOM = 3

@MustBeDocumented
@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY,
    AnnotationTarget.FIELD,
    AnnotationTarget.LOCAL_VARIABLE,
    AnnotationTarget.VALUE_PARAMETER
)
@Retention(AnnotationRetention.RUNTIME)
@IntDef(START, TOP, END, BOTTOM)
annotation class Position