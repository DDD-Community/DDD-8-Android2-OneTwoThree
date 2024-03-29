package com.inseoul.library_calendar

import java.util.*

class CalendarHelper {
    private val calendar by lazy { Calendar.getInstance() }

    fun getYear(): Int = calendar[Calendar.YEAR]

    fun nextYear() = calendar.set(Calendar.YEAR, getYear().plus(1))

    fun setYear(year: Int) = calendar.set(Calendar.YEAR, year)

    fun previousYear() = calendar.set(Calendar.YEAR, getYear().minus(1))

    fun getMonth(): Int = calendar[Calendar.MONTH].plus(other = 1)

    fun nextMonth() {
        val currentMonth = getMonth()
        if (currentMonth in 0..11) {
            setMonth(currentMonth + 1)
            setDay()
        } else {
            nextYear()
            setMonth(1)
            setDay()
        }
    }

    fun previousMonth() {
        var currentMonth = getMonth().minus(1)
        if (currentMonth < 1) {
            currentMonth = 12
            previousYear()
            setDay()
        }

         calendar.set(Calendar.MONTH, currentMonth.minus(1))
    }

    fun setMonth(month: Int) = calendar.set(Calendar.MONTH, month.minus(1))

    fun getDay(): Int = calendar[Calendar.DAY_OF_MONTH]

    fun setDay() = calendar.set(Calendar.DATE, 1)

    fun setDay(day: Int) = calendar.set(Calendar.DATE, day)

    fun getCurrentCalendar(): String = "${getYear()}년 ${getMonth()}월 ${getDay()}일"

    fun getCurrentYearAndMonth(): String = "${getYear()}년 ${getMonth()}월"

    fun getMaximumDay(): Int = calendar.getActualMaximum(Calendar.DATE)

    fun getCurrentWeekDay(): Int = calendar[Calendar.DAY_OF_WEEK]

    fun createCalendar(): List<Int> =
        mutableListOf<Int>().apply {
            for (i in 1..getMaximumDay()) {
                add(i)
            }
        }

    fun getFirstWeekDayEmptyCount(): Int {
        setDay()

        val firstWeekDay = getCurrentWeekDay()
        val emptyWeekDayList = mutableListOf<Int>()

        for (i in 0 until firstWeekDay) {
            emptyWeekDayList.add(i)
        }

        return emptyWeekDayList.size - 1
    }

    fun getLastWeekDayEmptyCount(): Int {
        setDay(getMaximumDay())

        val lastWeekDay = getCurrentWeekDay()
        val emptyWeekDayList = mutableListOf<Int>()

        return if (lastWeekDay == 7) {
            0
        } else {
            for (i in lastWeekDay..7) {
                emptyWeekDayList.add(i)
            }

            emptyWeekDayList.size - 1
        }
    }

    fun getLastDaysOfPreviousMonth(emptyCount: Int): List<Int> {
        if (emptyCount <= 0) return emptyList()

        val dayList = mutableListOf<Int>()
        val newCalendar = Calendar.getInstance().apply {
            set(Calendar.YEAR, getYear())
            set(Calendar.MONTH, getMonth().minus(2))
            setDay()
        }
        val maximumDay = newCalendar.getActualMaximum(Calendar.DATE)

        if (emptyCount == 1) {
            dayList.add(maximumDay)
        } else {
            for (i in maximumDay downTo maximumDay - (emptyCount -1)) {
                dayList.add(i)
            }
        }

        return if (dayList.size >= 2) {
            dayList.reversed()
        } else {
            dayList
        }
    }

    fun getFirstDaysOfNextMonth(emptyCount: Int): List<Int> {
        if (emptyCount <= 0) return emptyList()

        val dayList = mutableListOf<Int>()
        if (emptyCount == 1) {
            dayList.add(1)
        } else {
            for (i in 1..emptyCount) {
                dayList.add(i)
            }
        }

        return dayList
    }
}
