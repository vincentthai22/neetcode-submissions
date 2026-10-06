class Solution {
    fun singleNumber(nums: IntArray): Int {
        var countMap = mutableMapOf<Int, Int>()
        nums.forEach {
            countMap[it] = countMap.getOrPut(it, {0}) + 1
        }

        countMap.keys.forEach {
            if(countMap[it] == 1) {
                return it
            }
        }
        return 0
    }
}
