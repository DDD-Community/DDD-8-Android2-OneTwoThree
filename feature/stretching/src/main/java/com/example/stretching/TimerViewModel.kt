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

    private val _timerState = MutableStateFlow<TimerModel>(TimerModel())
    val timerState: StateFlow<TimerModel> = _timerState.asStateFlow()

    var countDown: CountDownTimer? = null
    val state = _timerState.value

    init {
        startTime(state.timeDuration)
        _timerState.value = TimerModel()
    }

    fun startTime(duration: Duration) {
        countDown = object : CountDownTimer(duration.toMillis(), 10) {
            override fun onTick(seconds: Long) {
                _timerState.value = TimerModel(
                    timeDuration = Duration.ofMillis(seconds),
                    remainingTime = seconds,
                    status = Status.RUNNING,
                    toggle = ButtonState.PAUSE
                )
            }

            override fun onFinish() {
                _timerState.value = _timerState.value.copy(
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
        _timerState.value = _timerState.value.copy(
            status = Status.STARTING,
            toggle = ButtonState.RESUME
        )
    }

    fun selectTimerState() {
        val state = _timerState.value

        when (state.status) {
            Status.STARTING -> {
                startTime(state.timeDuration)
            }
            Status.RUNNING -> {
                pauseTimer()
            }
            else -> {

            }
        }
    }
}