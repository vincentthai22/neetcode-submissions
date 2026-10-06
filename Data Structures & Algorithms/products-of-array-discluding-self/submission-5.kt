class Solution {
    // [1, 2, 4, 6]
    // []

    fun productExceptSelf(nums: IntArray): IntArray {
        var leftProducts = mutableListOf<Int>()
        var rightProducts = mutableListOf<Int>()

        for(leftIndex in 0 until nums.size) {
            var rightIndex = nums.lastIndex - leftIndex
            leftProducts.add(productOfPrev(leftIndex-1, leftIndex, nums, leftProducts))
            rightProducts.add(productOfPrev(rightIndex+1, rightIndex, nums, rightProducts))
        }
        rightProducts.reverse()

        for(i in 0 until nums.size) {
            nums[i] = productOfLeftAndRight(i, leftProducts, rightProducts)
        }
        
        return nums
    }

    private fun productOfPrev(prevIndex: Int, curr: Int, nums: IntArray, products: List<Int>): Int {
        var prevNum = 1
        var curr = nums[curr]
        if(prevIndex in 0 until nums.size) {
            prevNum = products[products.lastIndex]
        }

        return curr * prevNum
    }

    private fun productOfLeftAndRight(curr: Int, leftProducts: List<Int>, rightProducts: List<Int>): Int {
        var left = if(curr-1 > -1) {
            leftProducts[curr-1]
        } else {
            1
        }

        var right = if(curr+1 < rightProducts.size) {
            rightProducts[curr+1]
        } else {
            1
        }

        return left * right
    }
}
