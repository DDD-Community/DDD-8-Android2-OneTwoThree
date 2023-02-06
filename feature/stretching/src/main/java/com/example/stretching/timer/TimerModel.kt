package com.example.stretching

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.Duration

@RequiresApi(Build.VERSION_CODES.O)
data class TimerModel (
    val timeDuration: Duration = Duration.ofSeconds(30),
    val remainingTime: Long = timeDuration.toMillis(),
    val status: Status = Status.STARTING,
    val toggle: ButtonState = ButtonState.START
)

enum class Status {
    STARTING, RUNNING, FINISHING
}

enum class ButtonState {
    START, PAUSE, RESUME
}
