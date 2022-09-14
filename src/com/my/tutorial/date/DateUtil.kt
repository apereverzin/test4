package com.my.tutorial.date

import java.util.Calendar

fun MyDate.nextDay() = addTimeIntervals(TimeInterval.DAY, 1)

enum class TimeInterval {
    DAY, WEEK, YEAR
}

fun MyDate.addTimeIntervals(timeInterval: TimeInterval, n: Int): MyDate {
    val c = Calendar.getInstance()
    c.set(year, month, dayOfMonth)
    when (timeInterval) {
        TimeInterval.DAY -> c.add(Calendar.DAY_OF_MONTH, n)
        TimeInterval.WEEK -> c.add(Calendar.WEEK_OF_MONTH, n)
        TimeInterval.YEAR -> c.add(Calendar.YEAR, n)
    }
    return MyDate(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH))
}

operator fun MyDate.plus(timeInterval: TimeInterval): MyDate =
        this.addTimeIntervals(timeInterval, 1)
