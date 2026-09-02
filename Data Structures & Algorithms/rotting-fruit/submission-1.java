class Solution {
    int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    public int orangesRotting(int[][] grid) {
        Deque<int[]> q = new ArrayDeque<>();

        int fresh = 0;
        

        int time = 0;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j< grid[0].length; j++){
                if(grid[i][j] == 2){
                    q.offer(new int[]{i,j});
                    
                }else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }

        while(!q.isEmpty() && fresh > 0 ){
            
            int size = q.size();

            for(int x = 0; x<size; x++){
                int[] cur= q.poll();
                for(int[] d: dir){
                int r = cur[0] + d[0];
                int c = cur[1] + d[1];
                    if(r>=0 && r<grid.length && c>=0 && c<grid[0].length && grid[r][c] == 1){
                        q.offer(new int[]{r,c});
                        grid[r][c] = 2;
                        fresh--;
                    }
                }

            }
            time++;
            

            


        }

        return fresh==0 ? time : -1;


    }

    
}
