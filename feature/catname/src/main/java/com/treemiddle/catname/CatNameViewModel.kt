package com.treemiddle.catname

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.inseoul.domain.params.RegisterUserInfoUseCaseParams
import com.inseoul.domain.usecase.RegisterUserInfoUseCase
import com.inseoul.domain.usecase.base.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CatNameViewModel @Inject constructor(
      private val registerUserInfoUseCase: RegisterUserInfoUseCase
) : ViewModel() {
    init {
        viewModelScope.launch {
            when (val result = registerUserInfoUseCase(
                RegisterUserInfoUseCaseParams(
                    nickname = "telkjer",
                    firebaseToken = "f3aSGfttAQgmFdgE9hrb3EY:APA91bHtqNmemmk049P5VXpjaeVijcNbN19asnVqjwoNWj_z3Zy4qeyn046zKDDchdfpzGaGhHCO0uAps9GdJlWL5qp2mj-kvQXmYTLpyBv67JVc0z8I-mKhbNvgIuhs5WxkLWIIfgGKyo"
                )
            )) {
                is Result.Success -> {
                    println("????????????? ok!!!")
                }
                is Result.Error -> {
                    println("???????????????? fail: ${result.exception}")
                }
            }
        }
    }
}
