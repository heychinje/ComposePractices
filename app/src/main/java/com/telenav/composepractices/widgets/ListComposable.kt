package com.telenav.composepractices.widgets

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout

@Composable
fun <T> ListComposable(
    items: List<T>,
    modifier: Modifier = Modifier,
    isHorizontal: Boolean = true,
    itemContent: @Composable (T) -> Unit
) {
    Layout(
        modifier = modifier,
        content = {


            items.forEach { itemContent(it) }

            // TODO make sure that the first item is at the left
        }
    ) { measurables, constraints ->
        val placeables = measurables.map { it.measure(constraints) }

        val (totalWidth, totalHeight) = if (isHorizontal) {
            placeables.sumOf { it.width } to placeables.maxOf { it.height }
        } else {
            placeables.maxOf { it.width } to placeables.sumOf { it.height }
        }

        var (childX, childY) = if (isHorizontal) 0 to 0 else 0 to 0

        layout(totalWidth, totalHeight) {
            placeables.forEach { placeable ->
                placeable.place(childX, childY)
                if (isHorizontal) {
                    childX += placeable.width
                } else {
                    childY += placeable.height
                }
            }
        }
    }
}
