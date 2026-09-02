class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        
        int[] dp = new int[n];
        for(int i = 0; i < n; i++ ){
            dp[i] = 1;
        }
        for(int i = n - 1; i>=0; i-- ){
            for(int j = i+1; j<n; j++){
                if(nums[i] < nums[j]){
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
        }
        int res = -1;
        for(int i = 0; i < n; i++){
            res= Math.max(dp[i], res);
        }
        return res;
    }

    public int dfs(int i, int[] nums, int prevIndex,int[][] memo){
        if(i >= nums.length){
            return 0;
        }
        if(memo[i][prevIndex + 1] != -1){
            return memo[i][prevIndex + 1];
        }

        int skip = dfs(i+1, nums,prevIndex,memo);
        int take = 0;
        if(prevIndex == -1 || nums[prevIndex] < nums[i]){
            take = 1 + dfs(i+1, nums, i,memo);
        }

        memo[i][prevIndex + 1] = Math.max(take,skip);

        
        
        
        return Math.max(take,skip);

        


    }
}
