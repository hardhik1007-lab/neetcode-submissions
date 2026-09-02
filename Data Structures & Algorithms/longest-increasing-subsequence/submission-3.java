class Solution {
    public int lengthOfLIS(int[] nums) {
        
        int[][] memo = new int[nums.length][nums.length];

        for(int i = 0; i<nums.length; i++){
            for(int j = 0; j < nums.length; j++){
                memo[i][j] = -1;
            }
        }
        return dfs(0,nums,-1,memo);
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
