package com.treemiddle.catname

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewModelScope
import com.treemiddle.catname.navigation.catNameRoute
import com.treemiddle.catname.screen.CatNameScreen

@Composable
fun CatNameRoute(
    navigate: () -> Unit,
    viewModel: CatNameViewModel = hiltViewModel()
) {
    val catName = viewModel.catName.collectAsState()

    CatNameScreen(
        navigate = navigate,
        catName = catName.value,
        onCatNameChange = viewModel::setCatName,
        onClickConfirm = viewModel::onClickConfirm
    )
}
