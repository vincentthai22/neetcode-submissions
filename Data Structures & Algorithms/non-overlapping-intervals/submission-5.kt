class Solution {

    data class Interval(val start: Int, val end: Int)

    fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
        val intervals = intervals.map{Interval(it[0], it[1])}
        val sorted = intervals.sortedBy { it.end }

        var prev: Interval? = null
        var count = 0
        for(interval in sorted) {
            if(prev != null) {
                if(prev.isOverlapping(interval)) {
                    count++
                    continue
                }
            }

            prev = interval
        }
        return count
    }

    fun Interval.isOverlapping(other: Interval): Boolean {
        return other.start < end
    }
}
