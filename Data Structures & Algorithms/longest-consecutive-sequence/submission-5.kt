class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        if(nums.isEmpty()) return 0
        // add numbers to set in consecutive order O(n)
        val prioritySet = PriorityQueue<Int>(nums.size)
        prioritySet.addAll(nums.toSet())
        var count = 1
        var max = 1
        var prev: Int? = null

        while(prioritySet.isNotEmpty()) {
            val next = prioritySet.poll()

            if(prev != null) {
                if(prev+1 == next) {
                    count += 1
                    max = max(max, count)
                } else {
                    //reset
                    count = 1
                }
            }
            prev = next
        }

        return max
    }
}