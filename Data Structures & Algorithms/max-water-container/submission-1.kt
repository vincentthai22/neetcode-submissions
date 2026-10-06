class Solution {
    fun maxArea(heights: IntArray): Int {
        var maxArea = 0
        var left = 0
        var right = heights.lastIndex
        while(left < right) {
            val area = area(left, right, min(heights[left], heights[right]))
            maxArea = maxOf(maxArea, area)

            if(heights[left] < heights[right]) {
                left++
            } else {
                right--
            }
        }

        return maxArea
    }

    fun area(edge: Int, otherEdge: Int, minHeight: Int): Int {
        val width = abs(edge - otherEdge)
        return width * minHeight
    }

}
