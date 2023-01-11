package com.telenav.composepractices.effects

import androidx.annotation.FloatRange
import androidx.compose.foundation.background
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.*
import kotlin.math.*

private const val DEG_0 = 0.0
private const val DEG_90 = 90.0
private const val DEG_180 = 180.0
private const val DEG_270 = 270.0
private const val DEG_360 = 360.0

fun Modifier.linearGradient(
    vararg colorStops: Pair<Float, Color>,
    @FloatRange(from = DEG_0, to = DEG_360) degrees: Double = 90.0,
    tileMode: TileMode = TileMode.Clamp
) = this.background(
    com.telenav.composepractices.effects.linearGradient(
        colorStops = colorStops, degrees = degrees, tileMode = tileMode
    )
)

fun linearGradient(
    vararg colorStops: Pair<Float, Color>,
    @FloatRange(from = DEG_0, to = DEG_360) degrees: Double = 90.0,
    tileMode: TileMode = TileMode.Clamp
): Brush = LinearGradient(
    colors = List<Color>(colorStops.size) { i -> colorStops[i].second },
    stops = List<Float>(colorStops.size) { i -> colorStops[i].first },
    degrees = degrees,
    tileMode = tileMode
)

@Immutable
class LinearGradient internal constructor(
    private val colors: List<Color>,
    private val stops: List<Float>? = null,
    @FloatRange(from = DEG_0, to = DEG_360) private val degrees: Double,
    private val tileMode: TileMode = TileMode.Clamp
) : ShaderBrush() {

    override fun createShader(size: Size): Shader {
        val (w, h) = size.width to size.height

        /*
        In order to simplify the calculation, convert the angle to a signed degree. The positive
        value means the degree in [0, 180], and the negative value means the degree in (180, 360]
        */
        val signedDegrees = if (degrees.compareTo(DEG_180) > 0) DEG_180 - degrees else degrees

        val start = calculateStartPoint(w, h, abs(signedDegrees))
        val end = calculateEndPoint(w, h, abs(signedDegrees))

        return LinearGradientShader(
            colors = colors,
            colorStops = stops,
            from = if (signedDegrees.compareTo(0.0) >= 0) start else end,
            to = if (signedDegrees.compareTo(0.0) >= 0) end else start,
            tileMode = tileMode
        )
    }

    private fun calculateStartPoint(
        w: Float, h: Float,
        @FloatRange(from = DEG_0, to = DEG_180) degrees: Double,
    ): Offset = when {
        degrees.compareTo(DEG_0) == 0 -> Offset(w / 2, h)
        degrees.compareTo(DEG_90) == 0 -> Offset(0F, h / 2)
        degrees.compareTo(DEG_180) == 0 -> Offset(w / 2, 0F)
        degrees.compareTo(DEG_270) == 0 -> Offset(w, h / 2)
        else -> {
            val diagonalAngle1 = atan2(w, h)
            val diagonalAngle2 = DEG_180 - diagonalAngle1
            when {
                degrees.compareTo(diagonalAngle1) == 0 -> Offset(0F, h)
                degrees.compareTo(diagonalAngle2) == 0 -> Offset(0F, 0F)
                degrees.compareTo(DEG_0) > 0 && degrees.compareTo(diagonalAngle1) < 0 -> {
                    val convertedDegrees = degrees - DEG_0
                    val sinDegrees = sin(convertedDegrees.toRadians())
                    val cosDegrees = cos(convertedDegrees.toRadians())
                    val tanDegrees = tan(convertedDegrees.toRadians())
                    val hypotenuse = w / 2 - h / 2 * tanDegrees
                    val x = hypotenuse * cosDegrees * cosDegrees
                    val y = h + hypotenuse * cosDegrees * sinDegrees
                    Offset(x.toFloat(), y.toFloat())
                }
                degrees.compareTo(diagonalAngle1) > 0 && degrees.compareTo(DEG_90) < 0 -> {
                    val convertedDegrees = degrees - DEG_0
                    val sinDegrees = sin(convertedDegrees.toRadians())
                    val cosDegrees = cos(convertedDegrees.toRadians())
                    val tanDegrees = tan(convertedDegrees.toRadians())
                    val hypotenuse = h / 2 - w / 2 / tanDegrees
                    val x = -hypotenuse * sinDegrees * cosDegrees
                    val y = h - hypotenuse * sinDegrees * sinDegrees
                    Offset(x.toFloat(), y.toFloat())
                }
                degrees.compareTo(DEG_90) > 0 && degrees.compareTo(diagonalAngle2) < 0 -> {
                    val convertedDegrees = DEG_180 - degrees
                    val sinDegrees = sin(convertedDegrees.toRadians())
                    val cosDegrees = cos(convertedDegrees.toRadians())
                    val tanDegrees = tan(convertedDegrees.toRadians())
                    val hypotenuse = h / 2 - w / 2 / tanDegrees
                    val x = -hypotenuse * sinDegrees * cosDegrees
                    val y = hypotenuse * sinDegrees * sinDegrees
                    Offset(x.toFloat(), y.toFloat())
                }
                degrees.compareTo(diagonalAngle2) > 0 && degrees.compareTo(DEG_180) < 0 -> {
                    val convertedDegrees = DEG_180 - degrees
                    val sinDegrees = sin(convertedDegrees.toRadians())
                    val cosDegrees = cos(convertedDegrees.toRadians())
                    val tanDegrees = tan(convertedDegrees.toRadians())
                    val hypotenuse = w / 2 - h / 2 * tanDegrees
                    val x = hypotenuse * cosDegrees * cosDegrees
                    val y = -hypotenuse * cosDegrees * sinDegrees
                    Offset(x.toFloat(), y.toFloat())
                }
                else -> Offset(0F, 0F)
            }
        }
    }

    private fun calculateEndPoint(
        w: Float, h: Float,
        @FloatRange(from = DEG_0, to = DEG_180) degrees: Double,
    ): Offset = when {
        degrees.compareTo(DEG_0) == 0 -> Offset(w / 2, 0F)
        degrees.compareTo(DEG_90) == 0 -> Offset(w, h / 2)
        degrees.compareTo(DEG_180) == 0 -> Offset(w / 2, h)
        degrees.compareTo(DEG_270) == 0 -> Offset(0F, h / 2)
        else -> {
            val diagonalAngle1 = atan2(w, h)
            val diagonalAngle2 = DEG_180 - diagonalAngle1
            when {
                degrees.compareTo(diagonalAngle1) == 0 -> Offset(w, 0F)
                degrees.compareTo(diagonalAngle2) == 0 -> Offset(w, h)
                degrees.compareTo(DEG_0) > 0 && degrees.compareTo(diagonalAngle1) < 0 -> {
                    val convertedDegrees = degrees - DEG_0
                    val sinDegrees = sin(convertedDegrees.toRadians())
                    val cosDegrees = cos(convertedDegrees.toRadians())
                    val tanDegrees = tan(convertedDegrees.toRadians())
                    val hypotenuse = w / 2 - h / 2 * tanDegrees
                    val x = w - hypotenuse * cosDegrees * cosDegrees
                    val y = -hypotenuse * cosDegrees * sinDegrees
                    Offset(x.toFloat(), y.toFloat())
                }
                degrees.compareTo(diagonalAngle1) > 0 && degrees.compareTo(DEG_90) < 0 -> {
                    val convertedDegrees = degrees - DEG_0
                    val sinDegrees = sin(convertedDegrees.toRadians())
                    val cosDegrees = cos(convertedDegrees.toRadians())
                    val tanDegrees = tan(convertedDegrees.toRadians())
                    val hypotenuse = h / 2 - w / 2 / tanDegrees
                    val x = w + hypotenuse * sinDegrees * cosDegrees
                    val y = hypotenuse * sinDegrees * sinDegrees
                    Offset(x.toFloat(), y.toFloat())
                }
                degrees.compareTo(DEG_90) > 0 && degrees.compareTo(diagonalAngle2) < 0 -> {
                    val convertedDegrees = degrees - DEG_90
                    val sinDegrees = sin(convertedDegrees.toRadians())
                    val cosDegrees = cos(convertedDegrees.toRadians())
                    val tanDegrees = tan(convertedDegrees.toRadians())
                    val hypotenuse = h / 2 - w / 2 * tanDegrees
                    val x = w + hypotenuse * cosDegrees * sinDegrees
                    val y = h - hypotenuse * cosDegrees * cosDegrees
                    Offset(x.toFloat(), y.toFloat())
                }
                degrees.compareTo(diagonalAngle2) > 0 && degrees.compareTo(DEG_180) < 0 -> {
                    val convertedDegrees = DEG_180 - degrees
                    val sinDegrees = sin(convertedDegrees.toRadians())
                    val cosDegrees = cos(convertedDegrees.toRadians())
                    val tanDegrees = tan(convertedDegrees.toRadians())
                    val hypotenuse = w / 2 - h / 2 * tanDegrees
                    val x = w - hypotenuse * cosDegrees * cosDegrees
                    val y = h + hypotenuse * cosDegrees * sinDegrees
                    Offset(x.toFloat(), y.toFloat())
                }
                else -> Offset(0F, 0F)
            }
        }
    }

    private fun Double.toRadians(): Double = this * Math.PI / DEG_360
}