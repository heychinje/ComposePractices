package com.telenav.composepractices.samples

import androidx.annotation.StringDef

const val SCREEN_SAMPLES_HOME =
    "com.telenav.composepractices.examples.Destinations.SCREEN_SAMPLES_HOME"
const val SCREEN_EDGE_FADE = "com.telenav.composepractices.examples.Destinations.SCREEN_EDGE_FADE"
const val SCREEN_LINEAR_GRADIENT =
    "com.telenav.composepractices.examples.Destinations.SCREEN_LINEAR_GRADIENT"
const val SCREEN_SCROLL_BAR = "com.telenav.composepractices.examples.Destinations.SCREEN_SCROLL_BAR"
const val SCREEN_SHADOW = "com.telenav.composepractices.examples.Destinations.SCREEN_SHADOW"

@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY,
    AnnotationTarget.FIELD,
    AnnotationTarget.LOCAL_VARIABLE,
    AnnotationTarget.VALUE_PARAMETER,
    AnnotationTarget.TYPE
)
@Retention(AnnotationRetention.RUNTIME)
@StringDef(
    SCREEN_SAMPLES_HOME,
    SCREEN_EDGE_FADE,
    SCREEN_LINEAR_GRADIENT,
    SCREEN_LINEAR_GRADIENT,
    SCREEN_SHADOW
)
annotation class Destinations

internal const val ALL = "All Samples"
internal const val EFFECT_SAMPLE_EDGE_FADE = "Edge Fade"
internal const val EFFECT_SAMPLE_LINEAR_GRADIENT = "Linear Gradient"
internal const val EFFECT_SAMPLE_SHADOW = "Shadow"
internal const val COMPONENT_SAMPLE_SCROLL_BAR = "Scroll Bar"

@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY,
    AnnotationTarget.FIELD,
    AnnotationTarget.LOCAL_VARIABLE,
    AnnotationTarget.VALUE_PARAMETER,
    AnnotationTarget.TYPE
)
@Retention(AnnotationRetention.RUNTIME)
@StringDef(
    ALL,
    EFFECT_SAMPLE_EDGE_FADE,
    EFFECT_SAMPLE_LINEAR_GRADIENT,
    EFFECT_SAMPLE_SHADOW,
    COMPONENT_SAMPLE_SCROLL_BAR,
)
annotation class SampleName