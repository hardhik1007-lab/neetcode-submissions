class Solution {

    int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    public int islandPerimeter(int[][] grid) {

        boolean[][] visit = new boolean[grid.length][grid[0].length];

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    return dfs(i,j,grid,visit);
                }
            }
        }

        return 0;
        
    }

    public int dfs(int i, int j, int[][] grid, boolean[][] visit){
        if(visit[i][j] == true){
            return 0;
        }

        int perimeter = 0;
        visit[i][j] = true;

        for(int[] d : dir){
            int nr = i + d[0];
            int nc = j + d[1];

            if(nr < 0 || nr >= grid.length || nc < 0 || nc >= grid[0].length || grid[nr][nc] == 0){
                perimeter += 1;
            }else{
                perimeter += dfs(nr, nc, grid, visit);
            }
        }

        return perimeter;
    }
}