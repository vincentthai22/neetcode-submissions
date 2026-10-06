class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while(left <= right) {
            int halfway = (right + left)/2;
            int searched = nums[halfway];
            if(searched == target) {
                return halfway;
            } else if (searched < target) {
                left = halfway+1;
            } else {
                right = halfway-1;
            }
        }
        return -1;
    }
}
