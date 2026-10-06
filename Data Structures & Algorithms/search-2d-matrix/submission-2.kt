class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        var left = 0
        var right = (matrix.size * matrix[0].size)-1

        do {
            val middle = (right + left) / 2
            val (n, m) = getMiddleIndex(matrix, middle)
            var search = matrix[n][m]
            println("search:$search, target:$target")
            if(target < search) {
                right = middle
            } else if (target == search) {
                return true
            } else {
                left = middle+1
            }
        } while(left < right)
        
        if(left == right) {
            val (n,m) = getMiddleIndex(matrix, right)
            val search = matrix[n][m]
            return target == search
        }
        return false
    }

    fun getMiddleIndex(matrix: Array<IntArray>, index: Int): Pair<Int, Int> {
        val width = matrix[0].size
        var height = 0
        var decrementingIndex = index
        while(decrementingIndex >= width) {
            decrementingIndex -= width
            height++
        }
        println("decrementingIndex: $decrementingIndex, height: $height, width: $width middleIndex: $index")

        return Pair(height, decrementingIndex)
    }
}
