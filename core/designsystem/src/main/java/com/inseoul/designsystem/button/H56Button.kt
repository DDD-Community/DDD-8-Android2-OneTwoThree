package com.inseoul.designsystem.button

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun H56Button(
    modifier: Modifier = Modifier,
    title: String,
    cornerRadius: Int,
    backgroundColor: Color,
    textColor: Color,
    onClicked: () -> Unit
) {
    Button(
        modifier = modifier.height(height = 56.dp),
        shape = RoundedCornerShape(size = cornerRadius.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = backgroundColor),
        onClick = { onClicked() },
    ) {
        Text(
            text = title,
            color = textColor
        )
    }
}
