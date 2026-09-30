class Solution {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;

        Integer[][] dp = new Integer[n][n];

        for(int i = 0; i < n; i++){
            dp[i][i] = piles[i];
        }

        for(int l = 2; l < n+1; l++){
            for(int i = 0; i+l-1 < n; i++){
                int j = i+l-1;
                dp[i][j] = Math.max(piles[i] - dp[i+1][j], piles[j] - dp[i][j-1]);
            }
        }

        return dp[0][n-1] > 0 ? true : false;
        
    }

    public int dfs(int i, int j,int[] piles, Integer[][] memo){
        if(i > j){
            return 0;
        }

        if(memo[i][j] != null){
            return memo[i][j];
        }

        int res =  Math.max(piles[i] - dfs(i+1, j, piles,memo), piles[j] - dfs(i, j -1, piles,memo));

        memo[i][j] = res;
        return res;
    }
}