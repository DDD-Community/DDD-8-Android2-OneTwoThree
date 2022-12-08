package com.inseoul.designsystem.switchbutton

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.inseoul.designsystem.theme.Green300
import com.inseoul.designsystem.theme.gray00
import com.inseoul.designsystem.theme.gray300

@Composable
fun InseoulSwitch(
    scale: Float = 2f,
    width: Dp = 52.dp,
    height: Dp = 32.dp,
    gapBetweenThumbAndTrackEdge: Dp = 4.dp
) {
    val switchOn = remember { mutableStateOf(false) }
    val thumbRadius = (height / 2) - gapBetweenThumbAndTrackEdge
    val animatePosition = animateFloatAsState(
        targetValue = if (switchOn.value)
            with(LocalDensity.current) { (width - thumbRadius - gapBetweenThumbAndTrackEdge).toPx() }
        else
            with(LocalDensity.current) { (thumbRadius + gapBetweenThumbAndTrackEdge).toPx() }
    )

    Canvas(modifier = Modifier
        .size(width, height)
        .scale(scale = scale)
        .pointerInput(Unit) {
            detectTapGestures(
                onTap = {
                    switchOn.value = !switchOn.value
                }
            )
        }
    ) {
        drawRoundRect(
            color = if (switchOn.value) {
                Green300
            } else gray300,
            cornerRadius = CornerRadius(x = 100.dp.toPx(), y = 100.dp.toPx()),
        )
        drawCircle(
            color = gray00,
            radius = thumbRadius.toPx(),
            center = Offset(
                x = animatePosition.value,
                y = size.height / 2
            )
        )
    }
}