class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] memo = new int[cost.length];
        for(int i = 0; i < cost.length; i++){
            memo[i] = -1;
        }
        return Math.min(dfs(0,cost,memo), dfs(1,cost,memo));
    }
    public int dfs(int i, int[] cost, int[] memo){
        if(i >= cost.length){
            return 0;
        }

        if(memo[i] != -1){
            return memo[i];
        }
        int res = 0;

        res = Math.min(cost[i] + dfs(i+1, cost, memo), cost[i] + dfs(i+2,cost,memo));
        memo[i] = res;
        return res;

    }
}
