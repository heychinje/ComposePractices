package com.telenav.composepractices.samples.screens

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.telenav.composepractices.R
import com.telenav.composepractices.samples.widgets.BottomBar
import com.telenav.composepractices.samples.widgets.TopBar

private val contentBackground = Color(0xFFEEEEEE)

@Composable
fun RootScreen(
    screenName: String,
    @DrawableRes backIcon: Int? = R.drawable.ic_back,
    onBackClick: () -> Unit,
    content: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        topBar = { TopBar(backIcon, screenName) { onBackClick() } },
        bottomBar = { BottomBar() },
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(contentBackground),
            contentAlignment = Alignment.Center
        ) {
            content(it)
        }
    }
}