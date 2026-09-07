class Solution {
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {

        char[][] grid = new char[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                grid[i][j] = '.';
            }
        }

        solve(0, grid);
        return res;

        
    }

    public void solve(int i, char[][] grid){

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

        for(int c = 0; c < grid.length; c++){
            if(isSafe(i, c, grid)){
                grid[i][c] = 'Q';
                solve(i+1, grid);
                grid[i][c] = '.';
            }
        }



    }
    public boolean isSafe(int i, int j, char[][] grid){

        for(int r = 0; r < i; r++){
            if(grid[r][j] == 'Q'){
                return false;
            }
        }

        //upperleftdiagonal
        int r = i - 1;
        int c = j - 1;
        while(r >= 0 && c >= 0){
            if(grid[r][c] == 'Q'){
                return false;
            }
            r--;
            c--;
        }
        //upperrightdiagonal
        r = i - 1;
        c = j + 1;
        while(r >= 0 && c < grid.length){
            if(grid[r][c] == 'Q'){
                return false;
            }
            r--;
            c++;
        }

        return true;


    }
}
