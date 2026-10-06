class Solution {
    fun maxSubArray(nums: IntArray): Int {
        val sumList = mutableListOf<Int>()
        var max = nums.first()

        nums.forEachIndexed { index, curr -> 
            when {
                index == 0 -> sumList.add(curr)   
                else -> {
                    val prev = sumList[index-1]
                    val total = max(prev + curr, curr)
                    max = max(total, max)
                    sumList.add(total)
                }
            }
        }
        return max
    }
}
