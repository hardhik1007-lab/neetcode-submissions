class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;

        for(int i = 0; i < stones.length; i++){
            sum += stones[i];
        }

        int[][] dp = new int[stones.length + 1][sum * 2 + 1];
        for(int j = 0; j < sum * 2 + 1; j++){
            dp[stones.length][j] = Math.abs(j - sum);
        }

        for(int i = stones.length - 1; i >= 0; i--){
            for(int j = sum * 2; j>= 0; j-- ){
                if(j + stones[i] <= sum * 2 && j - stones[i] >= 0){
                    dp[i][j] = Math.min(dp[i+1][j + stones[i]], dp[i+1][j - stones[i]]);
                }   
            }
        }
        return dp[0][sum];
        
    }

    public int dfs(int i, int diff,  int[] stones, int[][] memo, int sum){
        if(i == stones.length){
            return Math.abs(diff);
        }



        if(memo[i][diff + sum] != -1){
            return memo[i][diff + sum];

        }

        int res = Math.min(dfs(i+1, diff + stones[i], stones, memo, sum), dfs(i+1, diff - stones[i], stones, memo, sum));

        memo[i][diff + sum] = res;

        return res;
    }
}