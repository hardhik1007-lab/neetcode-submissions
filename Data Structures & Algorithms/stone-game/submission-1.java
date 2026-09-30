class Solution {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;

        Integer[][] memo = new Integer[n][n];

        /*for(int i = 0; i < n; i++){
            Arrays.fill(memo[i], );
        }*/

        int res = dfs(0,n-1, piles, memo);
        if(res > 0){
            return true;
        }else{
            return false;
        }
        
    }

    public int dfs(int i, int j,int[] piles, Integer[][] memo){
        if(i > j){
            return 0;
        }

        if(memo[i][j] != null){
            return memo[i][j];
        }

        int res =  Math.max(piles[i] - dfs(i+1, j, piles,memo), piles[j] - dfs(i, j -1, piles,memo));

        memo[i][j] = res;
        return res;
    }
}