package com.inseoul.library_calendar

data class DayState(
    val year: String,
    val month: String,
    val day: String,
    val isActivated: Boolean,
    val isClickedDay: Boolean = false,
    val stretchCount: Int = 0,
    val currentCalendar: String = ""
) {
    fun isFirstInitialized(): Boolean {
        if (currentCalendar.isBlank()) {
            return false
        }

        try {
            val dateList = currentCalendar.split(" ")
            val currentYear = dateList[0]
            val currentMonth = dateList[1]
            val currentDay = dateList[2]

            if (
                currentYear == "${year}년" &&
                currentMonth == "${month}월" &&
                currentDay == "${day}일"
            ) {
                return true
            }
        } catch (e: Exception) {
            e.printStackTrace()
            return false
        }

        return false
    }
}
