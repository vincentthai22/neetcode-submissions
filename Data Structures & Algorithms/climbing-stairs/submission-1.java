class Solution {
    public int climbStairs(int n) {
        int[] memo = new int[n];
        
        for (int i = 0; i < n; i++) {
            if(i == 0) memo[0] = 1;
            else if (i == 1) memo[1] = 2;
            else {
                memo[i] = memo[i-1] + memo[i-2];
            }
        }
        return memo[n-1];
    }
}
