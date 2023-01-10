package com.telenav.composepractices.samples.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.telenav.composepractices.samples.SamplesViewModel
import com.telenav.composepractices.samples.constants.*

private val textColor = Color(0xFF000000)
private val borderColor = Color.Black

@Composable
fun SamplesHomeScreen(
    onItemClick: (@SampleName String) -> Unit,
    onBackClick: (@SampleName String) -> Unit,
    viewModel: SamplesViewModel = hiltViewModel()
) {
    RootScreen(
        screenName = SAMPLE_HOME,
        backIcon = null,
        onBackClick = { onBackClick(SAMPLE_HOME) }
    ) {
        LazyRow(
            modifier = Modifier.fillMaxSize()
        ) {
            items(viewModel.samples.value) { item ->
                Box(
                    modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
                ) {
                    Card(
                        modifier = Modifier
                            .padding(20.dp)
                            .size(400.dp)
                            .clickable { onItemClick(item) },
                        elevation = 4.dp,
                        shape = MaterialTheme.shapes.large,
                        border = BorderStroke(1.dp, borderColor)
                    ) {
                        Box(
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = item,
                                fontSize = 32.sp,
                                textAlign = TextAlign.Center,
                                color = textColor
                            )
                        }
                    }
                }
            }
        }
    }
}