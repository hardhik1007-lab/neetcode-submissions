class Solution {

    
    public int orangesRotting(int[][] grid) {
        Deque<int[]> que = new ArrayDeque<>();
        int fresh = 0;
        int min =0;
        for(int i = 0; i<grid.length;i++){
            for(int j = 0; j<grid[0].length;j++){
                if(grid[i][j]==1){
                    fresh++;
                }
                if(grid[i][j]==2){
                    que.add(new int[]{i,j});
                }
            }
        }
        int[][] directions = {{0,1},{1,0},{-1,0},{0,-1}};

        while(fresh>0 && !que.isEmpty()){
            int size= que.size();

            for(int k=0;k<size;k++){
                int[] temp = que.poll();
                for (int[] dir:directions){
                    int r= temp[0]+dir[0];
                    int c = temp[1] + dir[1];
                    if(r>=0 && r<=grid.length-1 && c>=0
                    && c<=grid[0].length-1 && grid[r][c] == 1 ){
                        grid[r][c] = 2;
                        fresh--;
                        que.add(new int[]{r,c});
                    }
                }

            }
            min+=1;

        }

        return fresh==0 ? min : -1;


    }
        
}
