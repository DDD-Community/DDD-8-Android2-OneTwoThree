package com.treemiddle.setting.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.inseoul.designsystem.toolbar.InseoulToolbar

@Composable
fun SettingsScreen(
    navigateToCatName: () -> Unit,
    navigateToNotification: () -> Unit
) {
    Surface {
        Column(modifier = Modifier.fillMaxSize()) {
            SettingsToolbar()
            SettingsMenu(
                menuDrawableImageVector = Icons.Default.AccountCircle,
                menuTitle = "고양이 이름 변경하기",
                navigate = navigateToCatName
            )
            SettingsMenu(
                menuDrawableImageVector = Icons.Default.Menu,
                menuTitle = "알림",
                navigate = navigateToNotification
            )
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp)
                    .background(Color.Blue)
                    .height(1.dp)
            )
            SettingsAppVersion(appVersion = "1.0")
        }
    }
}

// NOTE : InseoulToolbar를 사용해야 합니다.
@Composable
fun SettingsToolbar() {
    InseoulToolbar(
        modifier = Modifier.fillMaxWidth(),
        title = "설정",
        onImageClicked = {}
    )
}

@Composable
fun SettingsMenu(
    modifier: Modifier = Modifier,
    menuDrawableImageVector: ImageVector, // NOTE : 임시로 ImageVector로 설정합니다.
    menuTitle: String,
    navigate: () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(58.dp)
            .clickable { navigate() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier
                .padding(start = 18.dp)
                .size(24.dp),
            imageVector = menuDrawableImageVector,
            contentDescription = null
        )
        Text(
            modifier = Modifier
                .padding(start = 18.dp)
                .weight(1f),
            text = menuTitle,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
        Image(
            modifier = Modifier.padding(end = 16.dp),
            imageVector = Icons.Default.ArrowBack,
            contentDescription = null
        )
    }
}

@Composable
fun SettingsAppVersion(appVersion: String) {
    Column(modifier = Modifier.padding(start = 16.dp, top = 24.dp)) {
        Text(
            text = "앱 버전",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )
        Text(
            text = appVersion,
            fontSize = 14.sp
        )
    }
}
