class Solution {
    fun rob(nums: IntArray): Int {
        var max = 0
        if(nums.size < 4) {
            nums.forEach {
                max = maxOf(it, max)
            }
            return max
        }
        
        return maxOf(robPart(nums.sliceArray(1 until nums.size)), robPart(nums.sliceArray(0 until nums.size-1)))
    }

    fun robPart(nums: IntArray): Int {
        var max = 0
        nums.forEachIndexed { index, curr ->
            val nextIndex = index+2
            if(nextIndex > nums.lastIndex) return@forEachIndexed
            val prev = maxOf(index-1, 0)
            var next = nums[nextIndex]
            val minusFirst = 0// if(nextIndex == nums.lastIndex) -nums[0] else 0
            nums[nextIndex] = maxOf(next + curr + minusFirst, next + nums[prev])
            max = maxOf(nums[nextIndex], max)
        }
        return max
    }
}
