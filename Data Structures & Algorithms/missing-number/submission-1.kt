class Solution {
    fun missingNumber(nums: IntArray): Int {
        var missingNumberMask = 0
        
        nums.sorted().forEach {
            if(it != missingNumberMask) return missingNumberMask
            missingNumberMask++
        }
        return missingNumberMask
    }
}
