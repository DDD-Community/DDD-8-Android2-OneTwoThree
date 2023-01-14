package com.inseoul.library_calendar

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common.Constants.Companion.EMPTY_STRING
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CalendarViewModel @Inject() constructor() : ViewModel() {
    var calendarTitle = MutableStateFlow(EMPTY_STRING)
        private set

    private val calendarHelper = CalendarHelper()
    private val days = mutableListOf<DayState>()

    private val _calendarState: MutableList<DayState> = days.toMutableStateList()
    val calendarState: List<DayState>
        get() = _calendarState

    private var currentYear = EMPTY_STRING
    private var currentCalendar = EMPTY_STRING

    init {
        setCurrentCalendar()
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

    fun onDayClick(day: Int) {
        if (checkIsClickedDayOfDays()) {
            changeOldDayState()
            setNewDayState(day)
        } else {
            setNewDayState(day)
        }

        emitDayState(days)
    }

    private fun changeOldDayState() {
        val oldDayState = days.find { it.isClickedDay } ?: return

        val index = days.indexOf(oldDayState)
        val newDayState = oldDayState.copy(isClickedDay = false)

        days[index] = newDayState
    }

    private fun setNewDayState(day: Int) {
        val dayState = findDayStateInDays(day) ?: return
        val newDayState = dayState.copy(isClickedDay = true)

        val index = days.indexOf(dayState)
        days[index] = newDayState
    }

    private fun findDayStateInDays(clickedDay: Int): DayState? =
        days.find { it.day.toInt() == clickedDay && it.isActivated }

    private fun initalized() {
        if (days.isNotEmpty()) {
            days.clear()
        }

        val currentDays = calendarHelper.createCalendar()
        val year = calendarHelper.getYear()
        val firstWeekEmptyCount = getFirstWeekDayEmptyCount()
        val lastWeekEmptyCount = getLastWeekDayEmptyCount()
        val daysOfPreviousMonth = getLastDaysOfPreviousMonth(firstWeekEmptyCount)
        val daysOfNextMonth = getFirstDaysOfNextMonth(lastWeekEmptyCount)

        addDaysIfNeeded(daysOfPreviousMonth)
        addDaysIfNeeded(currentDays, isNeeded = true)
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

    private fun addDaysIfNeeded(
        dayList: List<Int>,
        year: String = calendarHelper.getYear().toString(),
        month: String = calendarHelper.getMonth().toString(),
        isNeeded: Boolean = false
    ) {
        if (dayList.isEmpty()) return

        dayList.forEach {
            days.add(
                DayState(
                    year = year,
                    month = month,
                    day = it.toString(),
                    isActivated = isNeeded,
                    stretchCount = (0..7).random(),
                    currentCalendar = currentCalendar
                )
            )
        }
    }

    private fun loadCalendarUi() {
        emitCalendarTitle()
        emitDayState(days)
    }

    private fun checkIsClickedDayOfDays(): Boolean = days.any { it.isClickedDay }

    private fun emitDayState(dayStateList: List<DayState>) {
        _calendarState.clear()
        _calendarState.addAll(dayStateList)
    }

    private fun emitCalendarTitle() {
        viewModelScope.launch {
            calendarTitle.emit(getCalendarToolbarTitle())
        }
    }

    private fun setCurrentCalendar() {
        val calendar = calendarHelper.getCurrentCalendar()

        currentYear = calendar.split(" ").first()
        currentCalendar = calendar
    }
}
