class Solution {
    fun lastStoneWeight(stones: IntArray): Int {
        val sorted = stones.sorted().toMutableList();
        var pointer = sorted.size-1;
        while(pointer > 0) {
            val result = abs(sorted[pointer] - sorted[pointer-1])
            sorted.removeAt(pointer--)
            if(result == 0 && pointer > 0) {
                sorted[pointer] = result
                continue
            }
            var index = 0
            val newIndex = sorted.indexOfFirst { value -> index++ >= pointer || value >=result }
            println("newIndex $newIndex, result: $result")
            println("sorted $sorted")
            sorted.add(newIndex, result)
        }
        return sorted[0]
    }
}
