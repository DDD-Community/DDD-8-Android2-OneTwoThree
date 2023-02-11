package com.inseoul.designsystem.textfield

import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.example.common.Constants
import com.inseoul.designsystem.icon.InseoulIcons
import com.inseoul.designsystem.theme.gray900

@Composable
fun InseoulTextField(
    modifier: Modifier = Modifier,
    label: String,
    placeholder: String,
    text: String,
    onValueChange: (String) -> Unit,
    textColor: Color = gray900
) {
    // NOTE : 디자인 수정 요망
    OutlinedTextField(
        modifier = modifier
            .fillMaxWidth()
            .height(60.dp),
        value = text,
        onValueChange = onValueChange,
        label = { Text(label) },
        placeholder = { Text(placeholder) },
        textStyle = TextStyle(color = textColor),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Black,
            unfocusedBorderColor = Color.Black,
            focusedLabelColor = Color.Black,
            cursorColor = Color.Black
        ),
        trailingIcon = {
            if (text.isNotBlank())
                Icon(
                    painter = painterResource(id = InseoulIcons.XCircleMono),
                    contentDescription = null
                )
        }
    )
}
