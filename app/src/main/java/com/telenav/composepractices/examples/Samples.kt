package com.telenav.composepractices.examples

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.*
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.telenav.composepractices.examples.screens.SamplesHomeScreen


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun Samples() {
    AnimatedNavHost(
        navController = rememberNavController(),
        startDestination = Destinations.SCREEN_SAMPLES_HOME,
    ) {
        composable(Destinations.SCREEN_SAMPLES_HOME) {
            SamplesHomeScreen()
        }
    }
}