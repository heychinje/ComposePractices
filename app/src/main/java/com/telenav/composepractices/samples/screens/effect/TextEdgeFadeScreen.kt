package com.telenav.composepractices.samples.screens.effect

import androidx.compose.foundation.gestures.Orientation.Vertical
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.telenav.composepractices.effects.linearFade
import com.telenav.composepractices.samples.constants.SAMPLE_TEXT_EDGE_FADE
import com.telenav.composepractices.samples.constants.SampleName
import com.telenav.composepractices.samples.ext.isReachedEnd
import com.telenav.composepractices.samples.ext.isReachedStart
import com.telenav.composepractices.samples.screens.RootScreen

private val START_LINEAR_FADE_COLOR_STOPS = arrayOf(
    0F to Color(0x00D9D9D9), 0.1774F to Color(0xFFD9D9D9), 1F to Color(0xFFD9D9D9)
)

private val END_LINEAR_FADE_COLOR_STOPS = arrayOf(
    0F to Color(0xFFD9D9D9), 0.8026F to Color(0xFFD9D9D9), 1F to Color(0x00D9D9D9)
)

private const val contentString =
    "1. Introduction\n" + "\n" + "These Website Standard Terms and Conditions written on this webpage shall manage your use of our website, Webiste Name accessible at Website.com.\n" + "\n" + "2. By using our Website, you accepted these terms and conditions in full. If you disagree with these terms and conditions or any part of these terms and conditions, you must not use our Website.\n" + "\n" + "3. Intellectual Property Rights\n" + "\n" + "Unless otherwise stated, we or our licensors own the intellectual property rights in the website and material on the website. Subject to the license below, all these intellectual property rights are reserved.\n" + "\n" + "4. License to use website\n" + "\n" + "You may view, download for caching purposes only, and print pages from the website for your own personal use, subject to the restrictions set out below and elsewhere in these terms and conditions.\n" + "\n" + "You must not:\n" + "republish material from this website (including republication on another website);\n" + "sell, rent or sub-license material from the website;\n" + "show any material from the website in public;\n" + "reproduce, duplicate, copy or otherwise exploit material on our website for a commercial purpose;\n" + "edit or otherwise modify any material on the website; or\n" + "redistribute material from this website except for content specifically and expressly made available for redistribution.\n" + "Where content is specifically made available for redistribution, it may only be redistributed within your organisation.\n" + "\n" + "5. Acceptable use\n" + "\n" + "You must not use our website in any way that causes, or may cause, damage to the website or impairment of the availability or accessibility of the website; or in any way which is unlawful, illegal, fraudulent or harmful, or in connection with any unlawful, illegal, fraudulent or harmful purpose or activity.\n" + "\n" + "6. User content\n" + "\n" + "In these website standard terms and conditions, “your user content” shall mean material (including without limitation text, images, audio material, video material and audio-visual material) that you submit to this website, for whatever purpose.\n" + "\n" + "You grant to us a worldwide, irrevocable, non-exclusive, royalty-free license to use, reproduce, adapt, publish, translate and distribute your user content in any existing or future media. You also grant to us the right to sub-license these rights, and the right to bring an action for infringement of these rights.\n" + "\n" + "Your user content must not be illegal or unlawful, must not infringe any third party's legal rights, and must not be capable of amounting to a criminal offence or give rise to a civil liability or otherwise be contrary to the law of any country or territory where it or they are or may be published or received.\n" + "\n" + "You must not submit any user content to the website that is or has ever been the subject of any threatened or actual legal proceedings or other similar complaint.\n" + "\n" + "We reserve the right to edit or remove any material submitted to our website, or stored on our servers, or hosted or published upon our website.\n" + "\n" + "7. Your content must not be illegal or unlawful, must not infringe any third party's legal rights, and must not be capable of amounting to a criminal offence or give rise to a civil liability or otherwise be contrary to the law of any country or territory where it or they are or may be published or received.\n" + "\n" + "8. Indemnity\n" + "\n" + "You agree to indemnify us, and our directors, officers, employees and agents, from and against any"

private val textColor = Color(0xFF000000)

@Composable
fun TextEdgeFadeScreen(
    onBackClick: (@SampleName String) -> Unit
) {
    val scrollState = rememberScrollState()
    val topFadeEnableState = remember { mutableStateOf(false) }
    val bottomFadeEnableState = remember { mutableStateOf(false) }
    LaunchedEffect(scrollState.maxValue, scrollState.value) {
        topFadeEnableState.value = scrollState.isReachedStart.not()
        bottomFadeEnableState.value = scrollState.isReachedEnd.not()
    }
    RootScreen(screenName = SAMPLE_TEXT_EDGE_FADE,
        onBackClick = { onBackClick(SAMPLE_TEXT_EDGE_FADE) }) {
        Text(
            text = contentString,
            color = textColor,
            textAlign = TextAlign.Start,
            fontSize = 32.sp,
            modifier = Modifier
                .padding(
                    horizontal = 40.dp
                )
                .fillMaxWidth()
                // start fade
                .linearFade(
                    orientation = Vertical,
                    colorStops = START_LINEAR_FADE_COLOR_STOPS,
                    isEnabled = topFadeEnableState.value
                )
                // end fade
                .linearFade(
                    orientation = Vertical,
                    colorStops = END_LINEAR_FADE_COLOR_STOPS,
                    isEnabled = bottomFadeEnableState.value
                )
                .verticalScroll(scrollState)
        )
    }
}