package com.my.tutorial.date

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) :
        Comparable<MyDate> {
    override operator fun compareTo(other: MyDate): Int {
        if (year.compareTo(other.year) == 0) {
            if (month.compareTo(other.month) == 0) {
                return month.compareTo(other.month);

            }
            return dayOfMonth.compareTo(other.dayOfMonth);
        }
        return year.compareTo(other.year);
    }

    operator fun rangeTo(other: MyDate) = DateRange(this, other)
}

fun compare(date1: MyDate, date2: MyDate) = date1 < date2

fun iterateOverDateRange(firstDate: MyDate, secondDate: MyDate, handler: (MyDate) -> Unit) {
    for (date in firstDate..secondDate) {
        handler(date)
    }
}
