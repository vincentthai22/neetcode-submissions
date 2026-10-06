class Solution {

    data class Interval(val start: Int, val end: Int)

    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {

        if(intervals.isEmpty()) return arrayOf(newInterval)
        if(newInterval.isEmpty()) return intervals

        val intervalList = intervals.map { Interval(it[0], it[1]) }
        val newInterval = Interval(newInterval[0], newInterval[1])
        var insertIndex = -1
        var overlapIndex = -1
        
        run {
            var prevInterval: Interval? = null
            intervalList.forEachIndexed() { index, interval ->
                if(interval.isOverlapping(newInterval)) {
                    // found overlap -> merge overlapping intervals
                    // bc its in ascending order overlap index will always overlap the front merger
                    // we need to calculate overlap interval
                    overlapIndex = index
                    return@run
                }
                
                if (prevInterval != null && newInterval.isBetween(prevInterval, interval)) {
                    insertIndex = index
                    return@run
                }

                if(index == 0 && interval.start > newInterval.end) {
                    insertIndex = 0
                    return@run
                }

                if(index == intervalList.lastIndex) {
                    //if we've reached here then we insert last
                    insertIndex = intervalList.lastIndex+1
                }
                
                prevInterval = interval
            }   
        }
        val newList = mutableListOf<Interval>()
        if(insertIndex != -1) {
            println("insert: $insertIndex")
            intervalList.forEachIndexed() { index, interval ->
                if(insertIndex == index) {
                    newList.add(newInterval)
                }
                newList.add(interval)
            }
            if(insertIndex == intervalList.lastIndex+1) {
                newList.add(newInterval)
            }
        }

        if(overlapIndex != -1) {
            println("overlap: $overlapIndex")
            var start = newInterval.start
            var end = newInterval.end
            intervalList.forEach {
                if(it.isOverlapping(newInterval)) {
                    start = min(start, it.start)
                    end = max(end, it.end)
                }
            }
            var hasAdded = false
            intervalList.forEachIndexed() { index, interval ->
                when {
                    interval.isOverlapping(newInterval) -> {
                        if(!hasAdded) {
                            hasAdded = true
                            newList.add(Interval(start, end))
                        }
                    }
                    else -> newList.add(interval)
                }
            }
        }

        return newList.toIntArray()
    }

    fun Interval.isBetween(front: Interval, back: Interval) =
        start > front.end && end < back.start

    fun Interval.isOverlapping(other: Interval): Boolean {
        val otherRange = other.start..other.end
        val range = start..end
        println("isoverlapping: $range otherRange: $otherRange")
        return start in otherRange || end in otherRange || other.start in range || other.end in range
    }


    fun List<Interval>.toIntArray() = map { intArrayOf(it.start, it.end) }.toTypedArray()

}
