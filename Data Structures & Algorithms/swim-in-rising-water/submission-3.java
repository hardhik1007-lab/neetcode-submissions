class Solution {
    int[][] dir = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public int swimInWater(int[][] grid) {

        int[][] shortest = new int[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                shortest[i][j] = Integer.MAX_VALUE;
            }
        }
        shortest[0][0] = grid[0][0];
        PriorityQueue<int[]> minheap = new PriorityQueue<>((a,b) -> Integer.compare(a[0],b[0]));

        minheap.offer(new int[]{grid[0][0], 0, 0});

        while(!minheap.isEmpty()){
            int[] cur = minheap.poll();
            
            int i = cur[1];
            int j = cur[2];
            int distance = cur[0];
            if(distance > shortest[i][j]){
                continue;
            }
            for(int[] d: dir){
                int r = d[0];
                int c = d[1];
                if(i+r >= grid.length || i+r < 0 || j+c >= grid[0].length || j+c < 0 ){
                    continue;
                }
                int newDistance = Math.max(distance, grid[i+r][j+c]);
                if(newDistance <  shortest[i+r][j+c]){
                    shortest[i+r][j+c] = newDistance;
                    minheap.offer(new int[]{shortest[i+r][j+c], i+r,j+c});
                }
                
            }
        }

        return shortest[grid.length - 1][grid[0].length - 1];




        
        
    }
}
