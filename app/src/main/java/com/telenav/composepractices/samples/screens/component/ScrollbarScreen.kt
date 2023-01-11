package com.telenav.composepractices.samples.screens.component

import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import com.telenav.composepractices.samples.COMPONENT_SAMPLE_SCROLL_BAR
import com.telenav.composepractices.samples.SampleName
import com.telenav.composepractices.samples.screens.RootScreen
import com.telenav.composepractices.samples.screens.component.scrollbar.ColumnScrollBar
import com.telenav.composepractices.samples.screens.component.scrollbar.TextScrollBar

@Composable
fun ScrollbarScreen(onBackClick: (@SampleName String) -> Unit) {
    RootScreen(
        screenName = COMPONENT_SAMPLE_SCROLL_BAR,
        onBackClick = { onBackClick(COMPONENT_SAMPLE_SCROLL_BAR) }
    ) {
        Row {
            ColumnScrollBar()
            TextScrollBar()
        }
    }
}