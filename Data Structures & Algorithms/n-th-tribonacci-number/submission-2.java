class Solution {
    public int tribonacci(int n) {

        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 1;
        }

        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for(int i = 3; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }

        return dp[n];
        
        
    }

    public int dfs(int n, int[] memo){
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 1;
        }

        if(memo[n] != -1){
            return memo[n];
        }

        int res = dfs(n-1,memo) + dfs(n-2,memo) + dfs(n-3,memo);
        memo[n]= res;
        return res;
    }
}