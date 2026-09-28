class Solution {
    
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n + 1][m + 1];

        for(int i = 0; i < n+1; i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }


        dp[n-1][m-1] = grid[n-1][m-1];

        
        for(int i = n - 1; i >= 0; i--){
            for(int j = m - 1; j >= 0; j--){

                if(i == n-1 && j == m-1){
                    continue;
                }

                dp[i][j] = grid[i][j] + Math.min(dp[i+1][j], dp[i][j+1]);

            }
        }

        return dp[0][0];
        
    }

    public int dfs(int[][] grid, int i, int j, int[][] memo){
        if(i > grid.length - 1 || i < 0 || j > grid[0].length - 1 || j < 0){
            return Integer.MAX_VALUE;

        }

        if(i == grid.length - 1 && j == grid[0].length - 1){
            return grid[i][j];
        }

        if(memo[i][j] != -1){
            return memo[i][j];
        }

        int res =grid[i][j] +  Math.min(dfs(grid, i + 1, j,memo), dfs(grid, i, j+1,memo));

        memo[i][j] = res;

        return res;
    }
}