package com.telenav.composepractices.samples.constants

import androidx.annotation.StringDef

internal const val SAMPLE_HOME = "All Samples"
internal const val SAMPLE_LAZY_COLUMN_EDGE_FADE = "Lazy Column Edge Fade"
internal const val SAMPLE_LAZY_ROW_EDGE_FADE = "Lazy Row Edge Fade"
internal const val SAMPLE_TEXT_EDGE_FADE = "Text Edge Fade"

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
    SAMPLE_HOME,
    SAMPLE_LAZY_COLUMN_EDGE_FADE,
    SAMPLE_LAZY_ROW_EDGE_FADE,
    SAMPLE_TEXT_EDGE_FADE
)
annotation class SampleName