class Solution {

    int[][] dp;
    int totalSum;
    public int findTargetSumWays(int[] nums, int target) {

        totalSum = 0;

        for(int num:nums){totalSum+=num;}
        dp = new int[nums.length][2*totalSum + 1];

        for(int i = 0; i <nums.length; i++){
            for(int j = 0; j <2 * totalSum +1 ; j++){
                dp[i][j] = Integer.MIN_VALUE;
            }
        }
        
        return dfs(nums, 0,  target, 0);
    }

    public int dfs(int[] nums, int t, int target, int i){

        


        if(i == nums.length){
            if(t==target){
                return 1;
            }else{
                return 0;
            }
        }
        
        if((dp[i][t+totalSum])!=Integer.MIN_VALUE){
            return dp[i][t+totalSum];
        }
        
        
       
        dp[i][t+totalSum]= dfs(nums, t + nums[i],  target, i+1)+ dfs(nums, t - nums[i],  target, i+1);

        return dp[i][t+totalSum];

    }
}
