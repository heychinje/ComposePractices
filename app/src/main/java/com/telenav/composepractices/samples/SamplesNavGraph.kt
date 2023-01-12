package com.telenav.composepractices.samples

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.telenav.composepractices.samples.screens.SamplesHomeScreen
import com.telenav.composepractices.samples.screens.component.ScrollbarScreen
import com.telenav.composepractices.samples.screens.effect.EdgeFadeScreen
import com.telenav.composepractices.samples.screens.effect.LinearGradientScreen
import com.telenav.composepractices.samples.screens.effect.ShadowScreen

@Composable
fun SamplesNavGraph() {
    val navController = rememberNavController()
    val startDestination = SCREEN_SAMPLES_HOME
    val onSampleItemClick: (@SampleName String) -> Unit = remember {
        { sampleName ->
            when (sampleName) {
                EFFECT_SAMPLE_EDGE_FADE -> SCREEN_EDGE_FADE
                EFFECT_SAMPLE_LINEAR_GRADIENT -> SCREEN_LINEAR_GRADIENT
                EFFECT_SAMPLE_SHADOW -> SCREEN_SHADOW
                COMPONENT_SAMPLE_SCROLL_BAR -> SCREEN_SCROLL_BAR
                else -> null
            }?.let {
                navController.navigate(it)
            }
        }
    }
    val onBackClick: (@SampleName String) -> Unit = remember {
        {
            navController.popBackStack()
        }
    }
    NavHost(
        navController = navController, startDestination = startDestination
    ) {
        composable(SCREEN_SAMPLES_HOME) { SamplesHomeScreen(onSampleItemClick, onBackClick) }

        // effect screens
        composable(SCREEN_EDGE_FADE) { EdgeFadeScreen(onBackClick) }
        composable(SCREEN_LINEAR_GRADIENT) { LinearGradientScreen(onBackClick) }
        composable(SCREEN_SHADOW) { ShadowScreen(onBackClick) }

        // component screens
        composable(SCREEN_SCROLL_BAR) { ScrollbarScreen(onBackClick) }
    }
}