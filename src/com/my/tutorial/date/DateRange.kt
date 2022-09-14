package com.my.tutorial.date

class DateRange(val start: MyDate, val endInclusive: MyDate): Iterable<MyDate> {
    override fun iterator() = MyIterator(this)

    operator fun contains(d: MyDate) = this.start <= d && d <= this.endInclusive
}

class MyIterator(val dr: DateRange): Iterator<MyDate> {
    var d: MyDate = dr.start

    override fun hasNext() = d < dr.endInclusive

    override fun next(): MyDate {
        val res = d
        d = d.nextDay()
        return res
    }
}

fun checkInRange(date: MyDate, first: MyDate, last: MyDate): Boolean {
    return date in DateRange(first, last)
}
