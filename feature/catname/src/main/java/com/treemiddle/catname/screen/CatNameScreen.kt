package com.treemiddle.catname.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.common.Constants.Companion.EMPTY_STRING
import com.inseoul.designsystem.button.H56Button
import com.inseoul.designsystem.icon.InseoulIcons.ArrowBack
import com.inseoul.designsystem.textfield.InseoulTextField
import com.inseoul.designsystem.theme.gray900
import com.inseoul.designsystem.toolbar.InseoulToolbar

@Composable
fun CatNameScreen(
    navigate: () -> Unit,
    catName: String,
    onCatNameChange: (String) -> Unit,
    onClickConfirm: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            InseoulToolbar(
                modifier = Modifier,
                title = EMPTY_STRING,
                backButtonImageResource = ArrowBack,
                onImageClicked = {
                    // NOTE : 뒤로 가기
                }
            )
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(160.dp),
                imageVector = Icons.Default.AccountBox,
                contentDescription = null
            )
            InseoulTextField(
                modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                label = "고양이 이름",
                placeholder = "이름을 적어주세요",
                text = catName,
                onValueChange = onCatNameChange
            )
            Text(
                modifier = Modifier.padding(start = 16.dp),
                text = "글자 수 2/20"
            )
        }

        CatNameButton { onClickConfirm() }
    }
}

@Composable
fun CatNameButton(
    modifier: Modifier = Modifier,
    onButtonClicked: () -> Unit
) {
    H56Button(
        modifier = modifier.fillMaxWidth(),
        title = "확인",
        cornerRadius = 0,
        backgroundColor = gray900,
        textColor = Color.White,
        onClicked = { onButtonClicked() }
    )
}
