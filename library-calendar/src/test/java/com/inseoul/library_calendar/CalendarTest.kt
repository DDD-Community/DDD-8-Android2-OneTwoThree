package com.inseoul.library_calendar

import org.junit.Assert
import org.junit.Before
import org.junit.Test

class CalendarTest {
    private lateinit var calendarHelper: CalendarHelper

    @Before
    fun setup() {
        calendarHelper = CalendarHelper()
    }

    @Test
    fun `getYear() 호출하면 현재 년도인 2022년을 반환한다`() {
        Assert.assertEquals(2022, calendarHelper.getYear())
    }

    @Test
    fun `getMonth()를 호출하면 현재 월인 12월을 반환한다`() {
        Assert.assertEquals(12, calendarHelper.getMonth())
    }

    @Test
    fun `getDay()를 호출하면 현재 일인 8일을 반환한다`() {
        Assert.assertEquals(8, calendarHelper.getDay())
    }

    @Test
    fun `getCurrentCalendar()를 호출하면 현재년도 월 일인 2022년 12월 8일을 반환한다`() {
        Assert.assertEquals("2022년 12월 8일", calendarHelper.getCurrentCalendar())
    }

    @Test
    fun `nextYear()를 호출하면 현재 년도에서 1년을 더한 2023년을 반환환다`() {
        calendarHelper.nextYear()

        Assert.assertEquals(2023, calendarHelper.getYear())
    }

    @Test
    fun `setYear()를 호출하면 원하는 년도로 변경할 수 있다`() {
        calendarHelper.setYear(1990)

        Assert.assertEquals(1990, calendarHelper.getYear())
    }

    @Test
    fun `previousYear()를 호출하면 현재 년도에서 1년을 뺀 2021년을 반환환다`() {
        calendarHelper.previousYear()

        Assert.assertEquals(2021, calendarHelper.getYear())
    }

    @Test
    fun `nextMonth()를 호출하면 다음 월인 1월을 반환한다`() {
        calendarHelper.nextMonth()

        Assert.assertEquals(1, calendarHelper.getMonth())
    }

    @Test
    fun `nextMonth()를 호출 시 현재 월이 12월일 경우 다음년도인 2023년 1월을 반환한다`() {
        calendarHelper.nextMonth()

        Assert.assertEquals(1, calendarHelper.getMonth())
        Assert.assertEquals(2023, calendarHelper.getYear())
    }

    @Test
    fun `setMonth()를 호출하면 원하는 월을 설정할 수 있다`() {
        calendarHelper.setMonth(month = 8)

        Assert.assertEquals(8, calendarHelper.getMonth())
    }

    @Test
    fun `2020년 7월일 경우 nextYear()을 호출하면 2022년 7월을 반환한다`() {
        calendarHelper.apply {
            setYear(2020)
            setMonth(7)
            nextYear()
        }

        Assert.assertEquals(2021, calendarHelper.getYear())
        Assert.assertEquals(7, calendarHelper.getMonth())
    }

    @Test
    fun `2002년 6월일 경우 nextMonth()를 호출하면 7월을 반환한다`() {
        calendarHelper.apply {
            setYear(2022)
            setMonth(6)
            nextMonth()
        }

        Assert.assertEquals(7, calendarHelper.getMonth())
    }

    @Test
    fun `previousMonth()를 호출하면 11월을 반환한다`() {
        calendarHelper.previousMonth()

        Assert.assertEquals(11, calendarHelper.getMonth())
    }

    @Test
    fun `2022년 10월일 때 previousMonth()를 호출하면 9월을 반환한다`() {
        calendarHelper.apply {
            setYear(2022)
            setMonth(10)
            previousMonth()
        }

        Assert.assertEquals(9, calendarHelper.getMonth())
    }

    @Test
    fun `2022년 1월일 때 previousMonth()를 호출하면 2021년 12월을 반환한다`() {
        calendarHelper.apply {
            setYear(2022)
            setMonth(1)
            previousMonth()
        }

        Assert.assertEquals(2021, calendarHelper.getYear())
        Assert.assertEquals(12, calendarHelper.getMonth())
    }

    @Test
    fun `12월일 경우 getMaximumDay()를 호출하면 마지막일인 31일을 반환한다`() {
        Assert.assertEquals(31, calendarHelper.getMaximumDay())
    }

    @Test
    fun `11월일 경우 getMaximumDay()를 호출하면 마지막일인 31일을 반환한다`() {
        calendarHelper.setMonth(11)

        Assert.assertEquals(30, calendarHelper.getMaximumDay())
    }

    @Test
    fun `9월일 경우 getMaximumDay()를 호출하면 마지막일인 30일을 반환한다`() {
        calendarHelper.setMonth(9)

        Assert.assertEquals(30, calendarHelper.getMaximumDay())
    }

    @Test
    fun `2022년 2월에서 getMaximumDay()를 호출하면 마지막일인 28일을 반환한다`() {
        calendarHelper.apply {
            setYear(2022)
            setMonth(2)
        }

        Assert.assertEquals(28, calendarHelper.getMaximumDay())
    }

    @Test
    fun `2020년 2월에서 getMaximumDay()를 호출하면 마지막일인 29일을 반환한다`() {
        calendarHelper.apply {
            setYear(2020)
            setMonth(2)
        }

        Assert.assertEquals(29, calendarHelper.getMaximumDay())
    }

    @Test
    fun `setDay() 파라미터에 15을 전달하면 getDay()에서 15을 반환한다`() {
        calendarHelper.setDay(15)

        Assert.assertEquals(15, calendarHelper.getDay())
    }

    @Test
    fun `2022년 7월 기준 getCurrentWeekDay()를 호출하면 금요일을 반환한다`() {
        calendarHelper.apply {
            setYear(2022)
            setMonth(7)
            setDay()
        }

        Assert.assertEquals(6, calendarHelper.getCurrentWeekDay())
    }

    @Test
    fun `2022년 2월 기준 getCurrentWeekDay()를 호출하면 화요일(3)을 반환한다`() {
        calendarHelper.apply {
            setMonth(2)
            setDay()
        }

        Assert.assertEquals(3, calendarHelper.getCurrentWeekDay())
    }

    @Test
    fun `2022년 12월 31기준 getCurrentWeekDay()를 호출하면 토요일(7)을 반환한다`() {
        calendarHelper.setDay(31)

        Assert.assertEquals(7, calendarHelper.getCurrentWeekDay())
    }

    @Test
    fun `2018년 4월 기준 getCurrentWeekDay()를 호출하면 월요일(2)을 반환한다`() {
        calendarHelper.apply {
            setYear(2018)
            setMonth(4)
        }

        Assert.assertEquals(2, calendarHelper.getCurrentWeekDay())
    }

    @Test
    fun `createCalendar() 파라미터에 2022년 12월을 전달하면 31개의 일이 반환된다`() {
        val list = calendarHelper.createCalendar()

        Assert.assertEquals(31, list.size)
    }

    @Test
    fun `createCalendar() 파라미터에 2022년 2월을 전달하면 28개의 일이 반환된다`() {
        calendarHelper.apply {
            setMonth(2)
            setDay()
        }

        val list = calendarHelper.createCalendar()

        Assert.assertEquals(28, list.size)
    }

    @Test
    fun `getFirstWeekDayEmptyCount()를 호출하면 첫째 주 비어있는 일수의 개수를 반환한다`() {
        Assert.assertEquals(4, calendarHelper.getFirstWeekDayEmptyCount())
    }

    @Test
    fun `22년 11월 기준 getFirstWeekDayEmptyCount()를 호출하면 첫째 주 비어있는 일수의 숫자인 2를 반환한다`() {
        calendarHelper.apply {
            setMonth(11)
        }

        Assert.assertEquals(2, calendarHelper.getFirstWeekDayEmptyCount())
    }

    @Test
    fun `22년 10월 기준 getFirstWeekDayEmptyCount()를 호출하면 첫째 주 비어있는 일수의 숫자인 6를 반환한다`() {
        calendarHelper.apply {
            setMonth(10)
        }

        Assert.assertEquals(6, calendarHelper.getFirstWeekDayEmptyCount())
    }

    @Test
    fun `22년 5월 기준 getFirstWeekDayEmptyCount()를 호출하면 첫째 주 비어있는 일수의 숫자인 0를 반환한다`() {
        calendarHelper.apply {
            setMonth(5)
        }

        Assert.assertEquals(0, calendarHelper.getFirstWeekDayEmptyCount())
    }

    @Test
    fun `22년 12월 기준 getLastWeekDayEmptyCount()를 호출하면 마지막 주 비어있는 일수의 숫자인 0을 반환한다`() {
        calendarHelper.getLastWeekDayEmptyCount()

        Assert.assertEquals(0, calendarHelper.getLastWeekDayEmptyCount())
    }

    @Test
    fun `22년 11월 기준 getLastWeekDayEmptyCount()를 호출하면 마지막 주 비어있는 일수의 숫자인 3을 반환한다`() {
        calendarHelper.setMonth(11)

        Assert.assertEquals(3, calendarHelper.getLastWeekDayEmptyCount())
    }

    @Test
    fun `22년 10월 기준 getLastWeekDayEmptyCount()를 호출하면 마지막 주 비어있는 일수의 숫자인 5을 반환한다`() {
        calendarHelper.setMonth(10)

        Assert.assertEquals(5, calendarHelper.getLastWeekDayEmptyCount())
    }

    @Test
    fun `22년 9월 기준 getLastWeekDayEmptyCount()를 호출하면 마지막 주 비어있는 일수의 숫자인 1을 반환한다`() {
        calendarHelper.setMonth(9)

        Assert.assertEquals(1, calendarHelper.getLastWeekDayEmptyCount())
    }

    @Test
    fun `22년 1월 기준 getLastWeekDayEmptyCount()를 호출하면 마지막 주 비어있는 일수의 숫자인 5을 반환한다`() {
        calendarHelper.setMonth(1)

        Assert.assertEquals(5, calendarHelper.getLastWeekDayEmptyCount())
    }
}
