class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int[][] memo = new int[obstacleGrid.length][obstacleGrid[0].length];

        for(int i = 0; i < obstacleGrid.length; i++){
            Arrays.fill(memo[i], -1);
        }

        return dfs(obstacleGrid, 0 ,0, memo);
        
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