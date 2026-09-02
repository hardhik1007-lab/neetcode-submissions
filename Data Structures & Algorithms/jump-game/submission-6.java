class Solution {
    public boolean canJump(int[] nums) {

        boolean[] dp = new boolean[nums.length];
        dp[nums.length -1] = true;
        for(int i = nums.length - 2; i >=0; i--){
            for(int j = 1; j <= nums[i]; j++){
                if((i+j >= nums.length - 1) || dp[i+j]){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0];

       
        
    }
    public boolean dfs(int[] nums,int i){
        if(i >= nums.length - 1){
            return true;
        }

        for(int j = 1; j <= nums[i]; j++){
            if(dfs(nums, i + j)){
                return true;
            }
        }

        return false;
    }
}
