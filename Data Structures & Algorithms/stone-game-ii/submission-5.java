class Solution {
    public int stoneGameII(int[] piles) {

        int n = piles.length;
        int[] suffix = new int[n+1];
        for(int i = n-1; i >= 0; i--){
            suffix[i] = piles[i] + suffix[i+1];
        }

        int[][] dp = new int[n+1][n+1];

        for(int i = n - 1; i >= 0; i--){
            int sum = suffix[i];
            for(int m = n; m >=1 ; m--){
                for(int j = i; j < n && j-i +1 <= 2*m; j++){

                    int newm = Math.max(m, j-i+1);
                    dp[i][m] = Math.max(sum - dp[j+1][newm], dp[i][m]);
                }
            }
        }

        return dp[0][1];      
        
    }

    public int dfs(int i, int[] piles, int m, Integer[][] memo, int[] suffix){

        if(i >= piles.length){
            return 0;
        }

        if(memo[i][m] != null){
            return memo[i][m];
        }

        int res = Integer.MIN_VALUE;

        int sum = suffix[i];

        for(int j = i; j < piles.length && j - i + 1 <= 2*m; j++){
            
            int newm = Math.max(m , j-i +1);

            res = Math.max(res, sum - dfs(j+1, piles, newm, memo,suffix));

             
            

        }

        memo[i][m] = res;

        return res;

    }
}