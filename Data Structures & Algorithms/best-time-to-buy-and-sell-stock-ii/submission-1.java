class Solution {
    public int maxProfit(int[] prices) {
        int[][] memo = new int[prices.length][2];
        for(int i = 0; i < prices.length; i++){
            for(int j = 0; j < 2; j++){
                memo[i][j] = -1;
            }
        }
        return dfs(prices, 0, false, memo);
        
    }

    public int dfs(int[] prices,int i, boolean holding, int[][] memo){
        if(i >= prices.length){
            return 0;
        }
        int j = holding ? 0 : 1;
        if(memo[i][j] != -1){
            return memo[i][j];
        }
        int res = 0;
        if(holding){
            res= Math.max(dfs(prices, i+1, true, memo),prices[i] + dfs(prices, i+1, false,memo));
        }else{
            res = Math.max(dfs(prices, i+1, false,memo), -prices[i] + dfs(prices, i+1, true,memo));
        }
        memo[i][j] = res;
        return res;
        
        
        

    }
} 