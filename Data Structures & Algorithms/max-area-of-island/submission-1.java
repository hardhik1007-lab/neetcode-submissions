class Solution {
    private static final int[][] directions= {{1,0},{0,1},{-1,0},{0,-1}};
    int max = 0;

    public int maxAreaOfIsland(int[][] grid) {

         

        for(int i =0; i <grid.length; i++){
            for(int j =0; j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    int area = dfs(i,j,grid, 0);
                    max = Math.max(area, max);

                }
                
            }
        }

        return max;
        
    }



    public int dfs(int i,int j, int[][] grid,int area){

        

        if(i<0 || j<0|| i>=grid.length || j>=grid[0].length || grid[i][j]==0 ){
           
            return 0;
        }

        area=1;


        grid[i][j] = 0;

        for(int[] dir: directions){
            area+=dfs(i+dir[0], j + dir[1],grid, area);
        }

        return area;

        

    }
}
