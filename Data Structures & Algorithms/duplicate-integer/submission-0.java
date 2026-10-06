class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashMap map = new HashMap<Integer, Integer>();        
        for(int num: nums) {
            if(map.get(num) != null) {
                return true;
            }
            map.put(num, 0);
        } 
        return false;
    }
}