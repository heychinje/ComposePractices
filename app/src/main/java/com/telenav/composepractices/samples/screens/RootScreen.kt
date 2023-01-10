package com.telenav.composepractices.samples.screens

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.telenav.composepractices.R
import com.telenav.composepractices.samples.widgets.BottomBar
import com.telenav.composepractices.samples.widgets.TopBar

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
        content = content
    )
}