package com.telenav.composepractices.samples.widgets

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val backgroundColor = Color(0xFFFF9800)
private val titleColor = Color(0xFFFFFFFF)
private val iconColor = Color(0xFFFFFFFF)

@Composable
fun TopBar(
    @DrawableRes iconResId: Int?, title: String, onBackClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .background(backgroundColor),
        verticalAlignment = Alignment.CenterVertically
    ) {
        iconResId?.let {
            Icon(modifier = Modifier
                .fillMaxHeight()
                .clickable { onBackClick() }
                .padding(8.dp),
                painter = painterResource(it),
                contentDescription = "back",
                tint = iconColor)
        }
        Text(
            modifier = Modifier.padding(if (iconResId == null) 16.dp else 0.dp),
            text = title,
            fontSize = 36.sp,
            color = titleColor
        )
    }
}
