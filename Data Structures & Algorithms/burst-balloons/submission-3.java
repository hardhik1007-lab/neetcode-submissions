class Solution {
    public int maxCoins(int[] nums) {
        int[] num = new int[nums.length +2];
        int n = nums.length;
        
        //padding
        for(int i = 0; i < num.length; i++){
            if(i == 0 || i == num.length -1){
                num[i] = 1;
            }else{
                num[i] = nums[i-1];
            }
            
        }
        //dp
        int[][] dp = new int[n + 2][n + 2];

        for(int len = 1; len <= n; len++){
            for(int l = 1; l + len - 1 <= n; l++){
                int r = l + len - 1;
                for(int i = l; i <= r; i++){
                    int coins = num[l-1] * num[i] * num[r+1];
                    dp[l][r] = Math.max(dp[l][r], dp[l][i-1] + coins + dp[i+1][r]);
                }
            }
        }

        return dp[1][n];

        
        
    }

    public int dfs(int[] nums, int l, int r,int[][] memo){
        if(l > r){
            return 0;
        }
        if(memo[l-1][r-1] != -1){
            return memo[l-1][r-1];
        }
        int best = 0;
        for(int i= l; i <= r; i++){
            int coins = nums[l-1] * nums[i] * nums[r+1];
            best = Math.max(best, dfs(nums, l, i-1,memo) + coins + dfs(nums, i + 1, r,memo));
        }
        memo[l-1][r-1] = best;
        return best;
    }
}
