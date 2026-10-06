class Solution {
    public int minCostClimbingStairs(int[] cost) {

        int[] memo = new int[cost.length];

        memo[0] = 0;
        memo[1] = 0;

        for(int i = 2; i < cost.length; i++) {
            int cost1 = cost[i-1];
            int cost2 = cost[i-2];
            memo[i] = Math.min(memo[i-1] + cost1, memo[i-2] + cost2);
        }

        return Math.min(memo[cost.length-1] + cost[cost.length-1], memo[cost.length-2] + cost[cost.length-2] );
    }
}
