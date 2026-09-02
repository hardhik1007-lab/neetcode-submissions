class Solution {
    public void solve(char[][] board) {

        for(int i = 0; i<board.length;i++){
            for(int j =0; j<board[0].length;j++){
                if(board[i][j] == 'O' && (i==0 || i==board.length-1 || j==0 || j==board[0].length-1)){
                    dfs(i,j,board);
                }
            }
        }

        for(int i = 0; i<board.length;i++){
            for(int j =0; j<board[0].length;j++){
                if(board[i][j] == 'O'){
                    board[i][j]= 'X';
                }

            }
        }

        for(int i = 0; i<board.length;i++){
            for(int j =0; j<board[0].length;j++){
                if(board[i][j] == 'H'){
                    board[i][j]= 'O';
                }

            }
        }




        
    }
    public void dfs(int i,int j, char[][] board){
        if(i<0||j<0||i==board.length||j==board[0].length|| board[i][j] !='O'){
            return;
        }
        board[i][j] = 'H';
        dfs(i+1,j,board);
        dfs(i,j+1,board);
        dfs(i,j-1,board);
        dfs(i-1,j,board);
    }
}
