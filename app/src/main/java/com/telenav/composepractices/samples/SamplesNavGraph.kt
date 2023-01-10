package com.telenav.composepractices.samples

import androidx.annotation.StringDef
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.telenav.composepractices.samples.constants.*
import com.telenav.composepractices.samples.screens.LazyColumnEdgeFadeScreen
import com.telenav.composepractices.samples.screens.LazyRowEdgeFadeScreen
import com.telenav.composepractices.samples.screens.SamplesHomeScreen

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
        composable(SCREEN_LAZY_COLUMN_EDGE_FADE) {
            LazyColumnEdgeFadeScreen(onBackClick)
        }
        composable(SCREEN_LAZY_ROW_EDGE_FADE) {
            LazyRowEdgeFadeScreen(onBackClick)
        }
    }
}