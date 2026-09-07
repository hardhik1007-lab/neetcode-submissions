class Solution {
    List<List<String>> res = new ArrayList<>();
    

    public List<List<String>> solveNQueens(int n) {

        char[][] grid = new char[n][n];
        boolean[] cols = new boolean[n];
        boolean[] diagonal1 = new boolean[2*n - 1];
        boolean[] diagonal2 = new boolean[2*n - 1];

        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                grid[i][j] = '.';
            }
        }

        solve(0, grid, cols, diagonal1, diagonal2 );
        return res;

        
    }

    public void solve(int i, char[][] grid, boolean[] cols, boolean[] diagonal1, boolean[] diagonal2){

        if(i == grid.length){

            List<String> curGrid = new ArrayList<>();
            for(int r = 0; r < grid.length; r++){
                
                StringBuilder row = new StringBuilder();
                for(int c = 0; c < grid.length; c++){
                    row.append(grid[r][c]);
                }
                curGrid.add(row.toString());

            }
            res.add(curGrid);
            return;
        }
        int n = grid.length;

        for(int c = 0; c < grid.length; c++){
            if(isSafe(i, c, cols, diagonal1, diagonal2, n)){
                grid[i][c] = 'Q';
                cols[c] = true;
                diagonal1[i - c + n - 1] = true;
                diagonal2[i + c] = true;
                solve(i+1, grid, cols, diagonal1, diagonal2);
                grid[i][c] = '.';
                cols[c] = false;
                diagonal1[i - c + n - 1] = false;
                diagonal2[i + c] = false;
            }
        }



    }
    public boolean isSafe(int i, int j, boolean[] cols, boolean[] diagonal1, boolean[] diagonal2,int n){
         

        if(cols[j]){
            return false;
        }

        if(diagonal1[i - j + n - 1]){
            return false;
        }

        if(diagonal2[i + j]){
            return false;
        }

        return true;

       


    }
}
