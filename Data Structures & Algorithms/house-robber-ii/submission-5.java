class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }
        int[] memo1 = new int[nums.length];
        int[] memo2 = new int[nums.length];
        for(int i = 0; i < memo1.length; i++){
            
                memo1[i] = -1;
                memo2[i]= -1;
            
        }

        return Math.max(dfs(0, n-2, nums,memo1), dfs(1,n-1, nums,memo2));
        
    }

    public int dfs(int i, int j, int[] nums, int[] memo){
        if(i>j){
            return 0;
        }

        int n = nums.length; 

        if(memo[i] != -1){
            return memo[i];
        }

        int res= 0;
        res = Math.max(nums[i] + dfs(i+2, j,nums, memo),dfs(i+1,j,nums, memo));
        memo[i] = res;
        return res;
    }
}
