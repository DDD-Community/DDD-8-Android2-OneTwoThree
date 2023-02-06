package com.example.stretching.finish

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class StretchingFinishViewModel() : ViewModel() {

    var count: Int? = 0

    fun increaseCount() {
        viewModelScope.launch {
            count = count?.plus(1)
        }
    }


}