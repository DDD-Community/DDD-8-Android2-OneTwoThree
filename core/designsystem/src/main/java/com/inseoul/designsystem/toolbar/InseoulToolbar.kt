package com.inseoul.designsystem.toolbar

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun InseoulToolbar(
    modifier: Modifier,
    title: String,
    @DrawableRes backButtonImageResource: Int?,
    @DrawableRes leftImageResource: Int?,
    @DrawableRes centerImageResource: Int?,
    @DrawableRes rightImageResource: Int?,
    onImageClicked: () -> Unit
) {
    Row(
        modifier = modifier.height(height = 56.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (backButtonImageResource != null && backButtonImageResource != 0) {
            InseoulToolbarImage(
                modifier = modifier,
                imageResource = backButtonImageResource,
                onClicked = { onImageClicked() }
            )
        }

        Text(
            modifier = Modifier
                .padding(start = 16.dp)
                .weight(1f),
            text = title
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
    modifier: Modifier,
    @DrawableRes imageResource: Int,
    onClicked: () -> Unit
) {
    Image(
        modifier = modifier
            .size(size = 48.dp)
            .clickable { onClicked() },
        painter = painterResource(id = imageResource),
        contentDescription = null
    )
}
