package com.telenav.composepractices.samples

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.telenav.composepractices.samples.constants.*
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SamplesViewModel @Inject constructor() : ViewModel() {
    private val _samples = mutableStateOf<List<String>>(
        listOf(
            SAMPLE_LAZY_COLUMN_EDGE_FADE,
            SAMPLE_LAZY_ROW_EDGE_FADE,
            SAMPLE_TEXT_EDGE_FADE,
        )
    )
    val samples: State<List<String>> = _samples
}