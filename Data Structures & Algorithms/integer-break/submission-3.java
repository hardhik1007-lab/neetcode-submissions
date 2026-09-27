class Solution {
    
    public int integerBreak(int n) {

        int[] dp = new int[n + 1];

        dp[1] = 1;

        for(int i = 2; i <= n; i ++){
            for(int j = 1; j < i; j++){
                
                dp[i] = Math.max(dp[i], j * dp[(i - j)]);
                dp[i] = Math.max(dp[i], j * (i - j));
                  
            }
        }

        return dp[n];
        
    }

    public int dfs(int n, int[] memo){

        if(n == 1){
            return 1;
        }


        if(memo[n] != 0){
            return memo[n];
        }
        
        int res = 1;
        for(int i = 1; i < n; i++){

            res = Math.max(res, i * (n-i));

            res = Math.max(res, i * dfs(n-i, memo));

            
        }

        memo[n] = res;

        return res;

    }
}