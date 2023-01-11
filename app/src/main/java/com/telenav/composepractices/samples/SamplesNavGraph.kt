package com.telenav.composepractices.samples

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.telenav.composepractices.samples.constants.*
import com.telenav.composepractices.samples.screens.component.ColumnScrollBarScreen
import com.telenav.composepractices.samples.screens.component.TextScrollBarScreen
import com.telenav.composepractices.samples.screens.effect.LazyColumnEdgeFadeScreen
import com.telenav.composepractices.samples.screens.effect.LazyRowEdgeFadeScreen
import com.telenav.composepractices.samples.screens.SamplesHomeScreen
import com.telenav.composepractices.samples.screens.effect.LinearGradientScreen
import com.telenav.composepractices.samples.screens.effect.TextEdgeFadeScreen

@Composable
fun SamplesNavGraph() {
    val navController = rememberNavController()
    val startDestination = SCREEN_SAMPLES_HOME
    val onSampleItemClick: (@SampleName String) -> Unit = remember {
        { sampleName ->
            when (sampleName) {
                SAMPLE_LAZY_COLUMN_EDGE_FADE -> SCREEN_LAZY_COLUMN_EDGE_FADE
                SAMPLE_LAZY_ROW_EDGE_FADE -> SCREEN_LAZY_ROW_EDGE_FADE
                SAMPLE_TEXT_EDGE_FADE -> SCREEN_TEXT_EDGE_FADE
                SAMPLE_LINEAR_GRADIENT -> SCREEN_LINEAR_GRADIENT

                SAMPLE_COLUMN_SCROLL_BAR -> SCREEN_COLUMN_SCROLL_BAR
                SAMPLE_TEXT_SCROLL_BAR -> SCREEN_TEXT_SCROLL_BAR
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
        composable(SCREEN_SAMPLES_HOME) {
            SamplesHomeScreen(onSampleItemClick, onBackClick)
        }

        // effect screens
        composable(SCREEN_LAZY_COLUMN_EDGE_FADE) {
            LazyColumnEdgeFadeScreen(onBackClick)
        }
        composable(SCREEN_LAZY_ROW_EDGE_FADE) {
            LazyRowEdgeFadeScreen(onBackClick)
        }
        composable(SCREEN_TEXT_EDGE_FADE) {
            TextEdgeFadeScreen(onBackClick)
        }
        composable(SCREEN_LINEAR_GRADIENT) {
            LinearGradientScreen(onBackClick)
        }

        // component screens
        composable(SCREEN_COLUMN_SCROLL_BAR) {
            ColumnScrollBarScreen(onBackClick)
        }
        composable(SCREEN_TEXT_SCROLL_BAR) {
            TextScrollBarScreen(onBackClick)
        }
    }
}