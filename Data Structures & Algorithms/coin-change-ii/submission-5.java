class Solution {
    public int change(int amount, int[] coins) {

        int[][] memo = new int[coins.length][amount + 1];
        for(int i = 0; i<coins.length ; i++){
            for(int j = 0; j < amount + 1 ; j++){
                memo[i][j] = -1;
            }
        }

        return dfs(amount,0, coins,memo);
        
    }

    public int dfs(int rem,int i, int[] coins, int[][] memo){
        if(rem == 0){
            return 1;
        }

        if(i >= coins.length || rem < 0){
            return 0;
        }

        if(memo[i][rem] != -1){
            return memo[i][rem];
        }
        int res = 0;

        res= dfs(rem - coins[i], i, coins, memo) + dfs(rem, i+1, coins, memo);
        memo[i][rem] = res;
        return res; 
    }
}
