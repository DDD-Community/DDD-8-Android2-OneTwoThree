package com.example.stretching.finish

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class StretchingFinishViewModel() : ViewModel() {

    var count: Int? = 0


    fun increaseCount() {
        viewModelScope.launch {
            println(count)
            count = count?.plus(1)
            //count.value = count.value.plus(1)
            println(count)
        }
    }


}