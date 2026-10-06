class Solution {
    fun rob(nums: IntArray): Int {
        if(nums.size == 1) return nums.first()
        var first = 0
        var second = 1
        while(first < nums.size-2) {
            var next = first+2
            var temp = next
            // println("first: $first second: $second next: $next nums.size-1: ${nums.size-1}")
            nums[next] = max(nums[first] + nums[next], if(next-3 > -1) nums[next] + nums[next-3] else 0)
            next = second+2
            // println("first: $first second: $second next: $next nums.size-1: ${nums.size-1}")
            if(next > nums.size-1) break
            nums[next] = max(nums[first] + nums[next], nums[second] + nums[next])
            first = temp
            second = next
        }

        return max(nums.last(), nums[nums.lastIndex-1])
    }
}
