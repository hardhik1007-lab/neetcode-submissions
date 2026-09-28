class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;

        int[][] dp = new int[n + 1][m + 1];

        if(obstacleGrid[n-1][m-1] == 1){
            return 0;
        }

        dp[n-1][m-1] = 1;
        

        for(int i = n - 1; i >= 0; i--){
            for(int j = m - 1; j >= 0; j--){
                if(i == n-1 && j == m-1){
                    continue;
                }

                if(obstacleGrid[i][j] != 1){
                    dp[i][j] = dp[i+1][j] + dp[i][j+1];
                }

            }
        }

        return dp[0][0];
        
    }

    public int dfs(int[][] obstacleGrid, int i, int j, int[][] memo){
        if(i > obstacleGrid.length - 1 || i < 0 || j > obstacleGrid[0].length - 1 || j < 0 || obstacleGrid[i][j] == 1){
            return 0;
        }

        if(i == obstacleGrid.length - 1 && j == obstacleGrid[0].length - 1){
            return 1;
        }

        if(memo[i][j] != -1){
            return memo[i][j];
        }

        int res = 0;

        res = dfs(obstacleGrid, i+1, j, memo) + dfs(obstacleGrid, i , j + 1, memo);

        memo[i][j] = res;

        return res;
    }
}