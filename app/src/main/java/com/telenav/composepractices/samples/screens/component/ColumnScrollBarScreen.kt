package com.telenav.composepractices.samples.screens.component

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.telenav.composepractices.components.END
import com.telenav.composepractices.components.scrollBar
import com.telenav.composepractices.samples.constants.SAMPLE_COLUMN_SCROLL_BAR
import com.telenav.composepractices.samples.constants.SAMPLE_LAZY_COLUMN_EDGE_FADE
import com.telenav.composepractices.samples.constants.SampleName
import com.telenav.composepractices.samples.screens.RootScreen
import com.telenav.composepractices.samples.widgets.WeekCard

private val data = listOf(
    "Sunday" to Color(0xFFF44336),
    "Monday" to Color(0xFFFF9800),
    "Tuesday" to Color(0xFFFFEB3B),
    "Wednesday" to Color(0xFF4CAF50),
    "Thursday" to Color(0xFF2196F3),
    "Friday" to Color(0xFF009688),
    "Saturday" to Color(0xFF9C27B0),
)

private val SCROLL_BAR_COLOR = Color(0xFF9EA3A6)

@Composable
fun ColumnScrollBarScreen(
    onBackClick: (@SampleName String) -> Unit
) {
    RootScreen(screenName = SAMPLE_COLUMN_SCROLL_BAR,
        onBackClick = { onBackClick(SAMPLE_COLUMN_SCROLL_BAR) }) {
        val scrollState = rememberScrollState()
        Column(
            modifier = Modifier
                .verticalScroll(scrollState)
                .scrollBar(
                    maxScrollableOffset = scrollState.maxValue,
                    scrolledOffset = scrollState.value,
                    orientation = Orientation.Vertical,
                    position = END,
                    color = SCROLL_BAR_COLOR,
                    strokeWidth = 2.dp,
                    isEnabled = scrollState.maxValue != 0 && scrollState.isScrollInProgress,
                    paddingTop = 10.dp,
                    paddingBottom = 10.dp,
                ),
        ) {
            data.forEach { WeekCard(item = it) }
        }
    }
}