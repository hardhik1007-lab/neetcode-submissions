class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
        int[][] indegree = new int[n][matrix[0].length];
        Queue<int[]> q = new ArrayDeque<>();
        int[][] dir = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < matrix[0].length; j++){         
                for(int[] d : dir){
                    int row = d[0];
                    int col = d[1];
                    if(i + row >=0 && j + col >= 0 && i + row<n && j + col < matrix[0].length && matrix[i + row][j + col] > matrix[i][j]){
                        indegree[i+row][j+col]++;                      
                    }

                }
                
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(indegree[i][j] == 0){
                    q.offer(new int[]{i,j});
                }
            }
        }

        int lis = 0;

        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] cur = q.poll();
                for(int[] d : dir){
                    int nr = d[0] + cur[0];
                    int nc = d[1] + cur[1];
                    if(nr >=0 && nc >= 0 && nr<n && nc < matrix[0].length && matrix[nr][nc] > matrix[cur[0]][cur[1]]){
                        indegree[nr][nc]--;
                        if(indegree[nr][nc] == 0){
                            q.offer(new int[]{nr,nc});
                        }
                    }

                }
            }
            lis++;
        }

        return lis;

        
    }
}
