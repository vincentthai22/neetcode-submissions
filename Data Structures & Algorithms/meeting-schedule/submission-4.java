/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        Interval largestInterval = new Interval(Integer.MAX_VALUE, Integer.MIN_VALUE);
        int index = 0;

        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                if(i1.start < i2.start) return -1;
                else if (i1.start == i2.start) return 0;
                else return 1;
            }
        });

        Interval prev = null;

        for(Interval interval: intervals) {
            if (prev != null) {
                if(isIntersecting(prev, interval)) {
                    return false;
                }
            } 
            prev = interval;
        }
        return true;
    }

    private boolean isIntersecting(Interval interval1, Interval interval2) {
        return isBetween(interval1.start, interval2.start, interval2.end) ||
        isBetween(interval1.end, interval2.start, interval2.end) ||
        isBetween(interval2.start, interval1.start, interval1.end) ||
        isBetween(interval2.end, interval1.start, interval1.end) || 
        isEqual(interval1, interval2);
    }

private boolean isEqual(Interval interval1, Interval interval2) {
    return interval1.start == interval2.start && interval2.end == interval1.end;
}

    private boolean isBetween(int target, int start, int end) {
        return target > start && target < end;
    }
}
