package com.inseoul.designsystem.toolbar

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.inseoul.designsystem.theme.gray900

@Composable
fun InseoulToolbar(
    modifier: Modifier,
    title: String,
    @DrawableRes backButtonImageResource: Int? = null,
    @DrawableRes leftImageResource: Int? = null,
    @DrawableRes centerImageResource: Int? = null,
    @DrawableRes rightImageResource: Int? = null,
    onImageClicked: () -> Unit
) {
    Row(
        modifier = modifier.height(height = 56.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (backButtonImageResource != null && backButtonImageResource != 0) {
            InseoulToolbarImage(
                imageResource = backButtonImageResource,
                onClicked = { onImageClicked() }
            )
        }

        Text(
            modifier = Modifier
                .padding(start = 16.dp)
                .weight(1f),
            text = title,
            color = gray900,
            fontWeight = FontWeight.Bold
        )

        if (leftImageResource != null && leftImageResource != 0) {
            InseoulToolbarImage(
                modifier = modifier,
                imageResource = leftImageResource,
                onClicked = { onImageClicked() }
            )
        }

        if (centerImageResource != null && centerImageResource != 0) {
            InseoulToolbarImage(
                modifier = modifier,
                imageResource = centerImageResource,
                onClicked = { onImageClicked() }
            )
        }

        if (rightImageResource != null && rightImageResource != 0) {
            InseoulToolbarImage(
                modifier = modifier,
                imageResource = rightImageResource,
                onClicked = { onImageClicked() }
            )
        }
    }
}

@Composable
fun InseoulToolbarImage(
    modifier: Modifier = Modifier,
    @DrawableRes imageResource: Int,
    onClicked: () -> Unit
) {
    Box(
        modifier = modifier
            .size(24.dp)
            .clickable { onClicked() },
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = imageResource),
            contentDescription = null
        )
    }
}
