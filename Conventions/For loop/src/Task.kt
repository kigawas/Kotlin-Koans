class DateRange(val start: MyDate, val end: MyDate) : Iterable<MyDate> {
    override fun iterator(): Iterator<MyDate> {
        return DateIterator(this)
    }
}

class DateIterator(val dateRange: DateRange) : Iterator<MyDate> {
    var current = dateRange.start
    override fun next(): MyDate {
        val next = current
        current = current.nextDay()
        return next
    }

    override fun hasNext(): Boolean {
        return current <= dateRange.end
    }
}

fun iterateOverDateRange(firstDate: MyDate, secondDate: MyDate, handler: (MyDate) -> Unit) {
    for (date in firstDate..secondDate) {
        handler(date)
    }
}
