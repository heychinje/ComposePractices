package com.telenav.composepractices.samples.screens.component

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.telenav.composepractices.components.END
import com.telenav.composepractices.components.scrollBar
import com.telenav.composepractices.samples.constants.SAMPLE_LAZY_COLUMN_EDGE_FADE
import com.telenav.composepractices.samples.constants.SAMPLE_TEXT_EDGE_FADE
import com.telenav.composepractices.samples.constants.SAMPLE_TEXT_SCROLL_BAR
import com.telenav.composepractices.samples.constants.SampleName
import com.telenav.composepractices.samples.screens.RootScreen

private val SCROLL_BAR_COLOR = Color(0xFF9EA3A6)
private const val contentString =
    "1. Introduction\n" + "\n" + "These Website Standard Terms and Conditions written on this webpage shall manage your use of our website, Webiste Name accessible at Website.com.\n" + "\n" + "2. By using our Website, you accepted these terms and conditions in full. If you disagree with these terms and conditions or any part of these terms and conditions, you must not use our Website.\n" + "\n" + "3. Intellectual Property Rights\n" + "\n" + "Unless otherwise stated, we or our licensors own the intellectual property rights in the website and material on the website. Subject to the license below, all these intellectual property rights are reserved.\n" + "\n" + "4. License to use website\n" + "\n" + "You may view, download for caching purposes only, and print pages from the website for your own personal use, subject to the restrictions set out below and elsewhere in these terms and conditions.\n" + "\n" + "You must not:\n" + "republish material from this website (including republication on another website);\n" + "sell, rent or sub-license material from the website;\n" + "show any material from the website in public;\n" + "reproduce, duplicate, copy or otherwise exploit material on our website for a commercial purpose;\n" + "edit or otherwise modify any material on the website; or\n" + "redistribute material from this website except for content specifically and expressly made available for redistribution.\n" + "Where content is specifically made available for redistribution, it may only be redistributed within your organisation.\n" + "\n" + "5. Acceptable use\n" + "\n" + "You must not use our website in any way that causes, or may cause, damage to the website or impairment of the availability or accessibility of the website; or in any way which is unlawful, illegal, fraudulent or harmful, or in connection with any unlawful, illegal, fraudulent or harmful purpose or activity.\n" + "\n" + "6. User content\n" + "\n" + "In these website standard terms and conditions, “your user content” shall mean material (including without limitation text, images, audio material, video material and audio-visual material) that you submit to this website, for whatever purpose.\n" + "\n" + "You grant to us a worldwide, irrevocable, non-exclusive, royalty-free license to use, reproduce, adapt, publish, translate and distribute your user content in any existing or future media. You also grant to us the right to sub-license these rights, and the right to bring an action for infringement of these rights.\n" + "\n" + "Your user content must not be illegal or unlawful, must not infringe any third party's legal rights, and must not be capable of amounting to a criminal offence or give rise to a civil liability or otherwise be contrary to the law of any country or territory where it or they are or may be published or received.\n" + "\n" + "You must not submit any user content to the website that is or has ever been the subject of any threatened or actual legal proceedings or other similar complaint.\n" + "\n" + "We reserve the right to edit or remove any material submitted to our website, or stored on our servers, or hosted or published upon our website.\n" + "\n" + "7. Your content must not be illegal or unlawful, must not infringe any third party's legal rights, and must not be capable of amounting to a criminal offence or give rise to a civil liability or otherwise be contrary to the law of any country or territory where it or they are or may be published or received.\n" + "\n" + "8. Indemnity\n" + "\n" + "You agree to indemnify us, and our directors, officers, employees and agents, from and against any"
private val textColor = Color(0xFF000000)

@Composable
fun TextScrollBarScreen(
    onBackClick: (@SampleName String) -> Unit
) {
    RootScreen(screenName = SAMPLE_TEXT_SCROLL_BAR,
        onBackClick = { onBackClick(SAMPLE_TEXT_SCROLL_BAR) }) {
        val scrollState = rememberScrollState()
        Text(
            text = contentString,
            color = textColor,
            textAlign = TextAlign.Start,
            fontSize = 32.sp,
            modifier = Modifier
                .padding(
                    horizontal = 40.dp
                )
                .verticalScroll(scrollState)
                .scrollBar(
                    maxScrollableOffset = scrollState.maxValue,
                    scrolledOffset = scrollState.value,
                    orientation = Orientation.Vertical,
                    position = END,
                    color = SCROLL_BAR_COLOR,
                    strokeWidth = 2.dp,
                    isEnabled = scrollState.maxValue != 0 && scrollState.isScrollInProgress,
                    paddingTop = 10.dp,
                    paddingBottom = 10.dp,
                )
                .fillMaxWidth()
        )
    }
}