class Solution {

    data class Interval(val start: Int, val end: Int) {
        operator fun plus(other: Interval): Interval {
            val start = minOf(start, other.start)
            val end = maxOf(end, other.end)
            return Interval(start, end)
        }
    }

    fun merge(ogIntervals: Array<IntArray>): Array<IntArray> {
        val intervals: List<Interval> = ogIntervals.map { Interval(it[0], it[1]) }
                .sortedBy { it.start }

        val merged = mutableListOf<Interval>()
        var prevInterval: Interval? = null
        var didMergeLast = false
        for(interval in intervals) {
            if(prevInterval != null) {
                // compare, merge if needed, add to new list
                if(!prevInterval.isIntersecting(interval)) {
                    merged.add(interval)
                    prevInterval = interval
                } else {
                    val mergedInterval = prevInterval + interval
                    merged.remove(prevInterval)
                    merged.add(mergedInterval)
                    prevInterval = mergedInterval
                }
            } else {
                merged.add(interval)
                prevInterval = interval
            }
        }

        if(merged.isEmpty() && prevInterval != null) {
            merged.add(prevInterval)
        }

        return merged.map { it.toIntArray() }.toTypedArray()
    }

    fun Interval.toIntArray(): IntArray = intArrayOf(start, end)

    fun Interval.isIntersecting(other: Interval): Boolean {
        val otherRange = other.start..other.end
        val thisRange = start..end
        return start in otherRange || end in otherRange || other.start in thisRange || other.end in thisRange
    }
}
