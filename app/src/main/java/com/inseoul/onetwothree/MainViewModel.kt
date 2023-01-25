package com.inseoul.onetwothree

import androidx.lifecycle.ViewModel
import com.google.firebase.messaging.FirebaseMessaging
import com.inseoul.domain.usecase.GetUserTokenUseCase
import com.inseoul.domain.usecase.SetUserTokenUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getUserTokenUseCase: GetUserTokenUseCase,
    private val setUserTokenUseCase: SetUserTokenUseCase
) : ViewModel() {

    fun getUserToken() {
        val token = getUserTokenUseCase()
        if (token.isBlank()) {
            requestUserToken()
        }
    }

    private fun requestUserToken() {
        FirebaseMessaging.getInstance().token.addOnCompleteListener {
            if (it.isSuccessful) {
                setUserTokenUseCase.invoke(it.result)
            }
        }
    }
}
