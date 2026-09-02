class Solution {
    public int uniquePaths(int m, int n) {
        int[][] memo = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                memo[i][j] = -1;
            }
        }
        return dfs(0,0,m,n,memo);
    }

    public int dfs(int i, int j, int m, int n, int[][] memo){
        if(i >= m || i < 0 || j >= n || j < 0){
            return 0;
        }

        if((i == m-1) && (j == n-1)){
            return 1;
        }

        if(memo[i][j] != -1){
            return memo[i][j];
        }

        int res = dfs(i+1,j, m, n, memo) + dfs(i,j+1,m,n, memo);

        memo[i][j] = res;

        return res;
    }
}
