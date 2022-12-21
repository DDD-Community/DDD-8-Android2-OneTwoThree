package com.inseoul.library_calendar

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common.Constants.Companion.EMPTY_STRING
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CalendarViewModel @Inject() constructor() : ViewModel() {
    private var calendarHelper = CalendarHelper()
    private val days = mutableListOf<DayState>()

    var calendarState = MutableStateFlow<List<DayState>>(emptyList())
        private set

    var calendarTitle = MutableStateFlow(EMPTY_STRING)
        private set

    init {
        initalized()
    }

    fun onPreviousClick() {
        calendarHelper.previousMonth()
        initalized()
    }
    fun onNextClick() {
        calendarHelper.nextMonth()
        initalized()
    }

    private fun initalized() {
        val currentDays = calendarHelper.createCalendar()
        val firstWeekEmptyCount = getFirstWeekDayEmptyCount()
        val lastWeekEmptyCount = getLastWeekDayEmptyCount()
        val daysOfPreviousMonth = getLastDaysOfPreviousMonth(firstWeekEmptyCount)
        val daysOfNextMonth = getFirstDaysOfNextMonth(lastWeekEmptyCount)

        addDaysIfNeeded(daysOfPreviousMonth)
        addDaysIfNeeded(currentDays, true)
        addDaysIfNeeded(daysOfNextMonth)

        loadCalendarUi()
    }

    private fun getLastWeekDayEmptyCount(): Int = calendarHelper.getLastWeekDayEmptyCount()

    private fun getFirstWeekDayEmptyCount(): Int = calendarHelper.getFirstWeekDayEmptyCount()

    private fun getLastDaysOfPreviousMonth(emptyCount: Int): List<Int> =
        calendarHelper.getLastDaysOfPreviousMonth(emptyCount)

    private fun getFirstDaysOfNextMonth(emptyCount: Int): List<Int> =
        calendarHelper.getFirstDaysOfNextMonth(emptyCount)

    private fun getCalendarToolbarTitle(): String = calendarHelper.getCurrentYearAndMonth()

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

    private fun clearDays() = days.clear()

    private fun loadCalendarUi() {
        emitCalendarTitle()
        emitDayState(days)
    }

    private fun emitDayState(dayStateList: List<DayState>) {
        viewModelScope.launch {
            calendarState.emit(dayStateList)
            delay(10) // NOTE : 이쪽 로직은 조금 더 생각해봐야 합니다. (컴포즈 원리)
            clearDays()
        }
    }

    private fun emitCalendarTitle() {
        viewModelScope.launch {
            calendarTitle.emit(getCalendarToolbarTitle())
        }
    }
}
