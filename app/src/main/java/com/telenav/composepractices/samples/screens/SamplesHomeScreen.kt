package com.telenav.composepractices.samples.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Divider
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
import com.telenav.composepractices.samples.ALL
import com.telenav.composepractices.samples.SamplesViewModel
import com.telenav.composepractices.samples.SCREEN_SAMPLES_HOME
import com.telenav.composepractices.samples.SampleName

private val textColor = Color(0xFF000000)

@Composable
fun SamplesHomeScreen(
    onItemClick: (@SampleName String) -> Unit,
    onBackClick: (@SampleName String) -> Unit,
    viewModel: SamplesViewModel = hiltViewModel()
) {
    RootScreen(screenName = ALL,
        backIcon = null,
        onBackClick = { onBackClick(ALL) }
    ) {
        Row(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(10.dp)
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Effects",
                    fontSize = 36.sp,
                    color = textColor,
                    textAlign = TextAlign.Center
                )
                LazyColumn {
                    items(viewModel.effects.value) { item ->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(100.dp)
                                .clickable { onItemClick(item) },
                            elevation = 4.dp,
                            shape = MaterialTheme.shapes.large,
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
                        Divider()
                    }
                }
            }

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(10.dp)
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Components",
                    fontSize = 36.sp,
                    color = textColor,
                    textAlign = TextAlign.Center
                )

                LazyColumn {
                    items(viewModel.components.value) { item ->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(100.dp)
                                .clickable { onItemClick(item) },
                            elevation = 4.dp,
                            shape = MaterialTheme.shapes.large,
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
                        Divider()
                    }
                }
            }
        }
    }
}