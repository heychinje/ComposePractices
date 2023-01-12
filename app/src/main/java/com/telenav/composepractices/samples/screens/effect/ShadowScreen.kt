package com.telenav.composepractices.samples.screens.effect

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.telenav.composepractices.samples.EFFECT_SAMPLE_SHADOW
import com.telenav.composepractices.samples.SampleName
import com.telenav.composepractices.samples.screens.RootScreen
import com.telenav.composepractices.samples.screens.effect.shadow.CircleShadow
import com.telenav.composepractices.samples.screens.effect.shadow.Irregular2Shadow
import com.telenav.composepractices.samples.screens.effect.shadow.IrregularShadow
import com.telenav.composepractices.samples.screens.effect.shadow.RectangleShadow

@Composable
fun ShadowScreen(onBackClick: (@SampleName String) -> Unit) {
    RootScreen(
        screenName = EFFECT_SAMPLE_SHADOW,
        onBackClick = { onBackClick(EFFECT_SAMPLE_SHADOW) }
    ) {
        Row {
            RectangleShadow()
            Spacer(Modifier.width(100.dp))
            CircleShadow()
            Spacer(Modifier.width(100.dp))
            IrregularShadow()
            Irregular2Shadow()
        }
    }
}