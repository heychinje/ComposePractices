package com.telenav.composepractices.samples

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.telenav.composepractices.samples.constants.*
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SamplesViewModel @Inject constructor() : ViewModel() {
    private val _effectSamples = mutableStateOf<List<String>>(
        listOf(
            SAMPLE_LAZY_COLUMN_EDGE_FADE,
            SAMPLE_LAZY_ROW_EDGE_FADE,
            SAMPLE_TEXT_EDGE_FADE,
            SAMPLE_LINEAR_GRADIENT,
        )
    )
    val effectSamples: State<List<String>> = _effectSamples


    private val _componentSamples = mutableStateOf<List<String>>(
        listOf(
            SAMPLE_COLUMN_SCROLL_BAR,
            SAMPLE_TEXT_SCROLL_BAR,
        )
    )
    val componentSamples: State<List<String>> = _componentSamples

}