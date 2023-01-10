package com.telenav.composepractices

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.telenav.composepractices.samples.SamplesNavGraph
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { SamplesNavGraph() }
    }

    @Composable
    fun Test() {
        SamplesNavGraph()
    }
}

