class Solution {
    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount+1];
        for(int i = 0; i < amount +1 ; i++){
            dp[i] = 100000;
        }
        dp[0] = 0;

        for(int amt = 1; amt<amount+1;amt++){
            for(int coin: coins){
                if(amt-coin>=0){
                    dp[amt] = Math.min(dp[amt], 1 + dp[amt - coin]);
                }
            }
        }

        return dp[amount] >= 100000 ? -1 : dp[amount];
        
    }
}
