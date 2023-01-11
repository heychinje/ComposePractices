package com.telenav.composepractices.samples

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SamplesViewModel @Inject constructor() : ViewModel() {
    private val _effects = mutableStateOf<List<String>>(
        listOf(
            EFFECT_SAMPLE_EDGE_FADE, EFFECT_SAMPLE_LINEAR_GRADIENT
        )
    )
    val effects: State<List<String>> = _effects


    private val _components = mutableStateOf<List<String>>(
        listOf(
            COMPONENT_SAMPLE_SCROLL_BAR
        )
    )
    val components: State<List<String>> = _components

}