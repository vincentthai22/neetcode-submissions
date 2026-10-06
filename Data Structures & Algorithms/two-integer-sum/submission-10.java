class Solution {
    public int[] twoSum(int[] nums, int target) {       
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        for(int i = 0; i < map.size(); i++) map.put(i, -1);

        if(nums.length == 2) {
            int[] baseCase = new int[2];
        baseCase[0] = 0;
        baseCase[1] = 1;
        return baseCase;
        }

        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int complement = target - num;
            int complementIndex = getInt(map, complement);
            map.put(num, i);
            if(complementIndex == -1) continue;
            if((nums[complementIndex] + num) == target) return twoSum(complementIndex, i);
        }
        int[] baseCase = new int[2];
        baseCase[0] = 0;
        baseCase[1] = 1;
        return baseCase;
    }

    private int getInt(HashMap<Integer, Integer> map, int index) {
        Integer value = map.get(index);
        return value == null ? -1 : value;
    }

    private int[] twoSum(int first, int second) {
        int[] twoSum = new int[2];
        twoSum[0] = first;
        twoSum[1] = second;
        return twoSum;
    }
}
