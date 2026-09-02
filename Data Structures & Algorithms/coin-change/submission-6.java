class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        for(int i = 0; i <memo.length ; i++){
            memo[i] = -1;
        }
        int res = dfs(coins, amount, memo);
        if(res>=100000){
            return -1;
        }else{
            return res;
        }
        
    }

    public int dfs(int[] coins, int rem , int[] memo){
        if(rem == 0 ){
            return 0;
        }
        if(memo[rem] != -1){
            return memo[rem];
        }
        
        int res = 100000;

        for(int coin : coins){
            if(rem - coin >=0){
                res =  Math.min(res, 1 + dfs(coins, rem - coin, memo));
                memo[rem] = res;
            }
            
        }

        return res;


    }
}
