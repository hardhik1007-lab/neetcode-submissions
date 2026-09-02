class Solution {
    
    Deque<int[]> q = new ArrayDeque<>();
    public void islandsAndTreasure(int[][] grid) {

        

        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j] == 0){
                    q.add(new int[]{i,j});
                }
            }
        }

        int dist =0;

        while(!q.isEmpty()){
            int size = q.size();

            for(int i= 0; i<size; i++){
                int[] node = q.poll();
                int r = node[0];
                int c = node[1];
                grid[r][c] = dist;

                add(r+1,c,grid);
                add(r-1,c,grid);
                add(r,c+1,grid);
                add(r,c-1,grid);

            }
            dist+=1;
            
        }
        
    }

    public void add(int i, int j, int[][] grid){
        if(i<0||i>=grid.length||j<0||j>=grid[0].length||grid[i][j] != Integer.MAX_VALUE ){
            return;
        }
        q.add(new int[]{i,j});
        grid[i][j] = -2;


    }
}
