package com.inseoul.designsystem.textfield

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.example.common.Constants
import com.inseoul.designsystem.icon.InseoulIcons

@Composable
fun InseoulTextField(
    modifier: Modifier = Modifier,
    label: String,
    placeholder: String,
) {
    val text = remember { mutableStateOf(TextFieldValue(Constants.EMPTY_STRING)) }
    OutlinedTextField(
        modifier = modifier
            .width(328.dp)
            .height(60.dp),
        value = text.value,
        onValueChange = { text.value = it },
        label = { Text(label) },
        placeholder = { Text(placeholder) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Black,
            unfocusedBorderColor = Color.Black,
            focusedLabelColor = Color.Black,
            cursorColor = Color.Black
        ),
        trailingIcon = {
            if (text.value.text.isNotEmpty())
                Icon(
                    painter = painterResource(id = InseoulIcons.XCircleMono),
                    contentDescription = null
                )
        }
    )
}