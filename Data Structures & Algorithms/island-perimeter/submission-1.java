class Solution {

    int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    public int islandPerimeter(int[][] grid) {

        
        int perimeter = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                
                if(grid[i][j] == 1){
                    perimeter += 4;
                    if(i > 0 && grid[i-1][j] == 1){
                        perimeter -= 2;
                    }
                    if(j > 0 && grid[i][j-1] == 1){
                        perimeter -= 2;
                    }
                }
            }
        }


        return perimeter;
        
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