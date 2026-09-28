class Solution {
    int min = Integer.MAX_VALUE;
    public int minPathSum(int[][] grid) {

        int[][] memo = new int[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++){
            Arrays.fill(memo[i], -1);
        }

        return dfs(grid, 0, 0,memo);
        
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