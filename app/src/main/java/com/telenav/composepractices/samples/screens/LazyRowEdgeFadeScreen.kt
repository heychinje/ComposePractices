package com.telenav.composepractices.samples.screens

import android.util.Log
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.dp
import com.telenav.composepractices.effects.linearFade
import com.telenav.composepractices.samples.constants.SAMPLE_LAZY_COLUMN_EDGE_FADE
import com.telenav.composepractices.samples.constants.SampleName
import com.telenav.composepractices.samples.ext.isReachedEnd
import com.telenav.composepractices.samples.ext.isReachedStart
import com.telenav.composepractices.samples.widgets.WeekCard

private val START_LINEAR_FADE_COLOR_STOPS = arrayOf(
    0F to Color(0x00D9D9D9), 0.0774F to Color(0xFFD9D9D9), 1F to Color(0xFFD9D9D9)
)

private val END_LINEAR_FADE_COLOR_STOPS = arrayOf(
    0F to Color(0xFFD9D9D9), 0.9026F to Color(0xFFD9D9D9), 1F to Color(0x00D9D9D9)
)

private val data = listOf(
    "Sunday" to Color(0xFFF44336),
    "Monday" to Color(0xFFFF9800),
    "Tuesday" to Color(0xFFFFEB3B),
    "Wednesday" to Color(0xFF4CAF50),
    "Thursday" to Color(0xFF2196F3),
    "Friday" to Color(0xFF009688),
    "Saturday" to Color(0xFF9C27B0),
)

@Composable
fun LazyRowEdgeFadeScreen(
    onBackClick: (@SampleName String) -> Unit
) {
    val state = rememberLazyListState()
    val startFadeEnableState = remember {
        mutableStateOf(false)
    }

    val endFadeEnableState = remember {
        mutableStateOf(false)
    }

    LaunchedEffect(state.firstVisibleItemIndex ,state.firstVisibleItemScrollOffset  ) {
        startFadeEnableState.value = state.isReachedStart.not()
        endFadeEnableState.value = state.isReachedEnd.not()
    }

    RootScreen(screenName = SAMPLE_LAZY_COLUMN_EDGE_FADE,
        onBackClick = { onBackClick(SAMPLE_LAZY_COLUMN_EDGE_FADE) }) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 200.dp),
            contentAlignment = Alignment.Center
        ) {
            LazyRow(
                state = state,
                modifier = Modifier
                    // start fade
                    .linearFade(
                        orientation = Orientation.Horizontal,
                        colorStops = START_LINEAR_FADE_COLOR_STOPS,
                        isEnabled = startFadeEnableState.value,
                        layoutDirection = LocalLayoutDirection.current
                    )
                    // end fade
                    .linearFade(
                        orientation = Orientation.Horizontal,
                        colorStops = END_LINEAR_FADE_COLOR_STOPS,
                        isEnabled = endFadeEnableState.value,
                        layoutDirection = LocalLayoutDirection.current
                    ),
            ) {
                items(data) { WeekCard(item = it) }
            }
        }
    }
}