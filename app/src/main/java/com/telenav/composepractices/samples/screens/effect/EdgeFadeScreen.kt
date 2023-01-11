package com.telenav.composepractices.samples.screens.effect

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.telenav.composepractices.samples.EFFECT_SAMPLE_EDGE_FADE
import com.telenav.composepractices.samples.SampleName
import com.telenav.composepractices.samples.screens.RootScreen
import com.telenav.composepractices.samples.screens.effect.edgefade.LazyColumnEdgeFade
import com.telenav.composepractices.samples.screens.effect.edgefade.LazyRowEdgeFade
import com.telenav.composepractices.samples.screens.effect.edgefade.TextEdgeFade

@Composable
fun EdgeFadeScreen(
    onBackClick: (@SampleName String) -> Unit
) {
    RootScreen(
        screenName = EFFECT_SAMPLE_EDGE_FADE,
        onBackClick = { onBackClick(EFFECT_SAMPLE_EDGE_FADE) }
    ) {
        Column {
            LazyRowEdgeFade()

            Row(
                modifier = Modifier.padding(horizontal = 40.dp)
            ) {
                LazyColumnEdgeFade()
                TextEdgeFade()
            }
        }
    }
}