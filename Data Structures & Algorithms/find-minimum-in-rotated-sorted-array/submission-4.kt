class Solution {
    fun findMin(nums: IntArray): Int {
        var left = 0
        var right = nums.lastIndex
        
        
        var leftValue = nums[left]
        var rightValue = nums[right]

        var min = minOf(leftValue, rightValue)
        
        while(left < right) {
            var middle = (right + left) / 2
            var midValue = nums[middle]
            
            if(leftValue < midValue) {
                // we're still increasing
                left = middle+1
                if(left < nums.size) {
                    leftValue = nums[left]
                    min = minOf(min, leftValue)
                }
            } else {
                // we found the new smallest
                right = middle-1
                if(right > -1) {
                    rightValue = nums[right]
                    min = minOf(min, rightValue)
                }
                
            }
            
            min = minOf(min, midValue)
        }
        return min
    }
}
