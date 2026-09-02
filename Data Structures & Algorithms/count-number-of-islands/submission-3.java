class Solution {
    int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    public int numIslands(char[][] grid) {
        

        
        int islands = 0;
        
        for(int i = 0;i<grid.length;i++){
            for(int j =0; j<grid[0].length; j++){
                if(grid[i][j]=='1'){
                    bfs(grid, i, j);
                    islands++;
                }
            }
        }
        return islands;
    }

    public void bfs(char[][] grid, int i, int j){
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{i,j});
        

        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            int r = cur[0];
            int c = cur[1];
            grid[r][c] = '0';

            for(int[] d : dir){
                int nr = r + d[0], nc = c+ d[1];
                if(nr<grid.length && nr>=0 && nc<grid[0].length && nc>=0 && grid[nr][nc] == '1'){
                   q.offer(new int[]{nr, nc}); 
                   grid[nr][nc] = '0';
                }
                
            }
        }
    }
}
