package com.telenav.composepractices.samples.ext

import androidx.compose.foundation.ScrollState

val ScrollState.isReachedStart: Boolean get() = value <= 0
val ScrollState.isReachedEnd: Boolean get() = value >= maxValue