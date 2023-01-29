package com.example.stretching

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.inseoul.designsystem.icon.InseoulIcons
import com.inseoul.designsystem.theme.bg
import com.inseoul.designsystem.toolbar.InseoulToolbar

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun StretchingListScreen(
    navigateToBack: () -> Unit,
) {
    Scaffold(
        topBar = {
            InseoulToolbar(
                modifier = Modifier,
                title = "손목 운동 운동",
                backButtonImageResource = InseoulIcons.ArrowBack,
                onImageClicked = navigateToBack
            )
        },
        content = {
            // 리스트 넣기
            Surface(
                modifier = Modifier.fillMaxWidth(),
                color = bg
            ) {
                Column(
                    modifier = Modifier.padding(
                        horizontal = 16.dp,
                        vertical = 12.dp
                    )
                ) {
                    StretchingList("옆으로 목 늘리기", "목과 어깨를 이어주는 근육을 이완시켜 뭉친 근육을 풀어줘요.")
                    Spacer(modifier = Modifier . height (12.dp))
                    StretchingList("목 굽히기", "목의 양 앞, 옆 근육들을 풀어주는 동작으로 목 통증 완화에 도움을 줘요")
                    Spacer(modifier = Modifier . height (12.dp))
                    StretchingList("어깨 돌리기", "손목 터널 증후군 예방과 손목 유연성 강화에 도움을 줘요")
                    Spacer(modifier = Modifier . height (12.dp))
                    StretchingList("팔 펴서 당기기", "내용4")
                    Spacer(modifier = Modifier . height (12.dp))
                    StretchingList("제목5", "내용5")
                }
            }
        }
    )
}

@Composable
fun StretchingList(
    title: String, content: String
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
    ) {
        Row() {
            Column(modifier = Modifier
                .padding(16.dp)
                .weight(2f)) {
                Text(text = title)
                Text(text = content)
                Text(text = "30초")
            }
            Image(
                modifier = Modifier
                    .weight(1f)
                    .width(100.dp)
                    .height(100.dp),
                imageVector = Icons.Default.Favorite,
                contentDescription = null
            )

        }
    }
}

@Preview
@Composable
fun StretchingListPreview() {
    StretchingList("제목","내용")
}

@Preview
@Composable
fun StretchingListScreenPreview() {
    StretchingListScreen {

    }
}