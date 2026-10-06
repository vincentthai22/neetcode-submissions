class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        val prioritySet = PriorityQueue<Int>()
        prioritySet.addAll(nums.toSet())

        var prev: Int? = null
        var count = 1;
        var max = 0
        while(prioritySet.isNotEmpty()) { 
            var next = prioritySet.poll()
            if(prev != null && prev+1 == next) {
                count++
            } else {
                count = 1
            }
            max = max(count, max)
            prev = next;
        }

        return max
    }
}