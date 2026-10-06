class Solution {
    data class Frequency(val key: Int, val count: Int)
     fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val map = mutableMapOf<Int, Int>() //count to int
        nums.forEach {
            map[it] = map.getOrDefault(it, 0) + 1
        }
        
        val descending = map.map { Frequency(it.key, it.value) }.sortedByDescending { it.count }
        val kFreq = mutableListOf<Int>()
        for(i in 0 until k) {
            kFreq.add(descending[i].key)
        }

        return kFreq.toIntArray()
    }
}
