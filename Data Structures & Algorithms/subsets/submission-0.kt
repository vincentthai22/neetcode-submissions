class Solution {
    fun subsets(nums: IntArray): List<List<Int>> {
        val sets = mutableListOf<List<Int>>()
        // add empty
        sets.add(listOf<Int>())

        nums.forEach { num ->

            for(i in 0 until sets.size) {
                val copy = sets[i].toMutableList()
                copy.add(num)
                sets.add(copy)
            }

        }
        return sets
    }
}
