package com.fcerio.ota.android.presentation.ui.components.progress

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.fcerio.ota.android.R
import com.fcerio.ota.android.presentation.ui.theme.black

/**
 * A custom progress bar that displays a linear progress with a customizable indicator.
 *
 * @param indicatorNumber The numeric value representing the progress percentage.
 * @param backgroundIndicatorColor The color of the background indicator.
 * @param indicatorPadding The padding around the progress indicator.
 * @param gradientColors The list of colors to be used for the gradient of the progress indicator.
 * @param animationDuration The duration of the animation for the progress indicator.
 * @param animationDelay The delay before starting the animation for the progress indicator.
 */
@Composable
fun CustomProgressBar(
    modifier: Modifier = Modifier,
    indicatorNumber: Int,
    backgroundIndicatorColor: Color = black.copy(alpha = 0.3f),
    indicatorPadding: Dp = 8.dp,
    gradientColors: List<Color> = listOf(
        MaterialTheme.colorScheme.primary,
        MaterialTheme.colorScheme.primary,
    ),
    animationDuration: Int = 1000,
    animationDelay: Int = 0
) {
    // State to animate the progress indicator.
    var percentage by remember {
        mutableFloatStateOf(-1f)
    }

    // Animate the progress number.
    val animateNumber = animateFloatAsState(
        targetValue = percentage,
        animationSpec = tween(
            durationMillis = animationDuration,
            delayMillis = animationDelay
        ), label = ""
    )

    // Trigger the LaunchedEffect to start the animation when the composable is first launched.
    LaunchedEffect(Unit) {
        percentage = indicatorNumber.toFloat()
    }

    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        Canvas(
            modifier = modifier
                .padding(start = indicatorPadding, end = indicatorPadding)
        ) {
            // Draw the background indicator.
            drawLine(
                color = backgroundIndicatorColor,
                cap = StrokeCap.Round,
                strokeWidth = size.height,
                start = Offset(x = 0f, y = size.height / 2),
                end = Offset(x = size.width, y = size.height / 2)
            )

            // Calculate and draw the progress indicator.
            val progress = (animateNumber.value / 100) * size.width
            drawLine(
                brush = Brush.linearGradient(colors = gradientColors),
                cap = StrokeCap.Round,
                strokeWidth = size.height,
                start = Offset(x = 0f, y = size.height / 2),
                end = Offset(x = progress, y = size.height / 2)
            )
        }
    }
}