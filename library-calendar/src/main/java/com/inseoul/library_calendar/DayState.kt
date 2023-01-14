package com.inseoul.library_calendar

data class DayState(
    val day: String,
    val isActivated: Boolean,
    val isClickedDay: Boolean = false,
    val stretchCount: Int = 0
)
