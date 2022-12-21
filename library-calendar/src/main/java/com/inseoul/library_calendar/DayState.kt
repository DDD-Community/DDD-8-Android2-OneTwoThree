package com.inseoul.library_calendar

data class DayState(
    val day: String,
    val isActivated: Boolean,
    var isClickedDay: Boolean = false
)
