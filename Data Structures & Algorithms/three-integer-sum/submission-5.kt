class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {

        var curr: Int
        
        var result = mutableListOf<List<Int>>()
        nums.sort()

        for(i in 0 until nums.size) {
            curr = nums[i]

            if(curr > 0) break
            if(i > 0 && curr == nums[i-1]) continue

            var left = i+1
            var right = nums.lastIndex
            
            while(left < right) {                
                var threeSum = curr + nums[left] + nums[right]
                when {
                    threeSum > 0 -> right-=1
                    threeSum < 0 -> left+=1
                    else -> {
                        result.add(listOf(curr, nums[left], nums[right]))
                        left += 1
                        right -= 1
                        while(left < right && nums[left] == nums[left-1]){
                            left++
                        }
                    }
                }
            }   
        }
        return result
    }
}
