class Solution {
    public boolean exist(char[][] board, String word) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(i, j, 0, board, word)) {
                    return true;
                }
            }
        }
        return false;

    }

    public boolean dfs(int i, int j, int k, char[][] board, String word) {
        int[][] dirs = { { 0, -1 }, { -1, 0 }, { 1, 0 }, { 0, 1 } };
        if(board[i][j]!=word.charAt(k)){
            return false;
        }
        
        if (k == word.length()-1) {
            return true;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[i].length || board[i][j] != word.charAt(k)) {
            return false;

        }

        board[i][j] = 0;
        for (int[] dir : dirs) {
            int x = dir[0] + i;
            int y = dir[1] + j;
            if (0 <= x && x < board.length && 0 <= y && y < board[x].length && dfs(x, y, k + 1, board, word)) {
                return true;

            }
        }
        board[i][j] = word.charAt(k);

        return false;

    }

}