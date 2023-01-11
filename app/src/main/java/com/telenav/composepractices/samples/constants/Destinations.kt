package com.telenav.composepractices.samples.constants

import androidx.annotation.StringDef

const val SCREEN_SAMPLES_HOME =
    "com.telenav.composepractices.examples.Destinations.SCREEN_SAMPLES_HOME"
const val SCREEN_LAZY_COLUMN_EDGE_FADE =
    "com.telenav.composepractices.examples.Destinations.SCREEN_LAZY_COLUMN_EDGE_FADE"
const val SCREEN_LAZY_ROW_EDGE_FADE =
    "com.telenav.composepractices.examples.Destinations.SCREEN_LAZY_ROW_EDGE_FADE"
const val SCREEN_TEXT_EDGE_FADE =
    "com.telenav.composepractices.examples.Destinations.SCREEN_TEXT_EDGE_FADE"
const val SCREEN_LINEAR_GRADIENT =
    "com.telenav.composepractices.examples.Destinations.SCREEN_LINEAR_GRADIENT"

const val SCREEN_COLUMN_SCROLL_BAR =
    "com.telenav.composepractices.examples.Destinations.SCREEN_COLUMN_SCROLL_BAR"
const val SCREEN_TEXT_SCROLL_BAR =
    "com.telenav.composepractices.examples.Destinations.SCREEN_TEXT_SCROLL_BAR"

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
    SCREEN_LAZY_COLUMN_EDGE_FADE,
    SCREEN_LAZY_ROW_EDGE_FADE,
    SCREEN_TEXT_EDGE_FADE,
    SCREEN_LINEAR_GRADIENT,

    SCREEN_COLUMN_SCROLL_BAR,
    SCREEN_TEXT_SCROLL_BAR
)
annotation class Destinations
