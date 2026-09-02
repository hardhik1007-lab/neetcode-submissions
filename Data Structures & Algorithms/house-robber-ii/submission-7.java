class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1){
            return nums[0];
        }
        
        int[] dp = new int[n+2];
        int[] dp2 = new int[n+2];

        

        for(int i = n-2; i >=0 ; i--){
            dp[i] = Math.max(nums[i] + dp[i+2], dp[i+1]);
        }
        for(int i = n-1; i >=1 ; i--){
            dp2[i] = Math.max(nums[i] + dp2[i+2], dp2[i+1]);
        }

        return Math.max(dp[0], dp2[1]);
        
    }
}
