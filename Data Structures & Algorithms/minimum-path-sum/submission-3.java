class Solution {
    
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] dp = new int[m + 1];

        
        Arrays.fill(dp, Integer.MAX_VALUE);
        


        dp[m-1] = grid[n-1][m-1];

        
        for(int i = n - 1; i >= 0; i--){
            for(int j = m - 1; j >= 0; j--){

                if(i == n-1 && j == m-1){
                    continue;
                }

                dp[j] = grid[i][j] + Math.min(dp[j], dp[j+1]);

            }
        }

        return dp[0];
        
    }

    
}