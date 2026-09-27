class Solution {
    public int numSquares(int n) {
        int[] dp  = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j*j <= n; j++){
                if(i - (j*j) >= 0){
                    dp[i] = Math.min(dp[i], 1 + dp[i - (j*j)]);
                }
            }
        }

        return dp[n];
        
    }

    public int dfs(int n, int[] memo){
        if(n == 0){
            return 0;
        }
        if(memo[n] != -1){
            return memo[n];
        }

        int res = Integer.MAX_VALUE;

        for(int i = 1; i*i <= n; i++){
            res = Math.min(res, 1 + dfs(n - (i*i), memo));
        }

        memo[n] = res;

        return res;
    }
}