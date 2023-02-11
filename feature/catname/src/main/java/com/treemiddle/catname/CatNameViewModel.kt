package com.treemiddle.catname

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common.Constants
import com.inseoul.domain.params.RegisterUserInfoUseCaseParams
import com.inseoul.domain.usecase.GetUserTokenUseCase
import com.inseoul.domain.usecase.RegisterUserInfoUseCase
import com.inseoul.domain.usecase.base.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CatNameViewModel @Inject constructor(
      private val registerUserInfoUseCase: RegisterUserInfoUseCase,
      private val getUserTokenUseCase: GetUserTokenUseCase
) : ViewModel() {
    private val _catName = MutableStateFlow(Constants.EMPTY_STRING)
    val catName: StateFlow<String>
        get() = _catName

    fun setCatName(catName: String) {
        _catName.value = catName
    }

    fun onClickConfirm() {
        if (catName.value.isBlank()) {
            return
        }

        requestCatName()
    }

    private fun requestCatName() = viewModelScope.launch {
        when (
            val result = registerUserInfoUseCase(createRegisterUserInfoParams())
        ) {
            is Result.Success -> {
                // something
            }
            is Result.Error -> {
                // something
            }
        }
    }

    private fun createRegisterUserInfoParams(): RegisterUserInfoUseCaseParams =
        RegisterUserInfoUseCaseParams(
            nickname = catName.value,
            firebaseToken = getUserTokenUseCase()
        )

}
