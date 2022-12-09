package com.inseoul.library_calendar

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CalendarViewModel @Inject() constructor() : ViewModel() {
    private var calendarHelper = CalendarHelper()

    private val days = mutableListOf<DayState>()

    init {
        initalized()
    }

    fun getCalendarDays(): List<DayState> = days

    fun getCalendarToolbarTitle(): String = calendarHelper.getCurrentYearAndMonth()

    private fun initalized() {
        val currentDays = calendarHelper.createCalendar()
        val firstWeekEmptyCount = getFirstWeekDayEmptyCount()
        val lastWeekEmptyCount = getLastWeekDayEmptyCount()
        val daysOfPreviousMonth = getLastDaysOfPreviousMonth(firstWeekEmptyCount)
        val daysOfNextMonth = getFirstDaysOfNextMonth(lastWeekEmptyCount)

        addDaysIfNeeded(daysOfPreviousMonth)
        addDaysIfNeeded(currentDays, true)
        addDaysIfNeeded(daysOfNextMonth)
    }

    private fun getLastWeekDayEmptyCount(): Int = calendarHelper.getLastWeekDayEmptyCount()

    private fun getFirstWeekDayEmptyCount(): Int = calendarHelper.getFirstWeekDayEmptyCount()

    private fun getLastDaysOfPreviousMonth(emptyCount: Int): List<Int> =
        calendarHelper.getLastDaysOfPreviousMonth(emptyCount)

    private fun getFirstDaysOfNextMonth(emptyCount: Int): List<Int> =
        calendarHelper.getFirstDaysOfNextMonth(emptyCount)

    private fun addDaysIfNeeded(dayList: List<Int>, isNeeded: Boolean = false) {
        if (dayList.isEmpty()) return

        dayList.forEach {
            days.add(
                DayState(
                    day = it.toString(),
                    isActivated = isNeeded
                )
            )
        }
    }
}
