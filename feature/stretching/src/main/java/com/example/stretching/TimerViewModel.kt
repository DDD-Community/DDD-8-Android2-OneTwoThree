package com.example.stretching

import android.os.Build
import android.os.CountDownTimer
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.time.Duration

@RequiresApi(Build.VERSION_CODES.O)
class TimerViewModel : ViewModel() {

    private val _viewState = MutableStateFlow<TimerModel>(TimerModel())
    val viewState: StateFlow<TimerModel> = _viewState.asStateFlow()

    var countDown: CountDownTimer? = null

    init {
        _viewState.value = TimerModel()
    }

    fun startTime(duration: Duration) {
        countDown = object : CountDownTimer(duration.toMillis(), 10) {
            override fun onTick(seconds: Long) {
                _viewState.value = TimerModel(
                    timeDuration = Duration.ofMillis(seconds),
                    remainingTime = seconds,
                    status = Status.RUNNING,
                    toggle = ButtonState.PAUSE
                )
            }

            override fun onFinish() {
                _viewState.value = _viewState.value.copy(
                    timeDuration = Duration.ZERO,
                    status = Status.FINISHING,
                    toggle = ButtonState.START
                )
            }
        }
        countDown?.start()
    }

    fun pauseTimer() {
        countDown?.cancel()
        _viewState.value = _viewState.value.copy(
            status = Status.STARTED,
            toggle = ButtonState.RESUME
        )
    }

    fun resetTimer() {
        countDown?.cancel()
        _viewState.value = _viewState.value.copy(
            status = Status.STARTED,
            timeDuration = Duration.ofMillis(30000L),
            toggle = ButtonState.START
        )
    }

    fun buttonSelection() {
        val state = _viewState.value

        when (state?.status) {
            Status.STARTED -> {
                startTime(state.timeDuration)
            }
            Status.RUNNING -> {
                pauseTimer()
            }
            Status.FINISHING -> {
                resetTimer()
            }
        }

    }
}