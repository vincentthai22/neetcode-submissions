/**
 * Definition of Interval:
 * class Interval(var start: Int, var end: Int) {}
 */

class Solution {

    data class Room(var start: Int, var end: Int)

    fun minMeetingRooms(intervals: List<Interval>): Int {
            // sort by start time
            // move through
            // determine if intersecting
            // if intersecting create new room
            // Rooms should have a running start and end time for easy search

            var intervals = intervals.sortedWith( compareBy<Interval> { it.start })
            val rooms = mutableListOf<Room>()

            for(interval in intervals) {
                rooms.find { room -> !interval.range.isIntersecting(room.start until room.end) }?.let {
                    // room that doesn't intersect is found
                    it.end = interval.end
                } ?: run {
                    // all existing rooms intersect, create a new one
                    rooms.add(Room(interval.start, interval.end))
                }
            }
            return rooms.size
    }

    fun IntRange.isIntersecting(otherRange: IntRange): Boolean {
        val range = start until endInclusive
        return start in otherRange || endInclusive in otherRange || otherRange.start in range || otherRange.endInclusive in range
    }

    val Interval.range: IntRange
        get() = start until end
}
