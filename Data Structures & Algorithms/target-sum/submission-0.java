class Solution {
    public int findTargetSumWays(int[] nums, int target) {
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
        
        
        int res = 0;
        res += dfs(nums, t + nums[i],  target, i+1);
        res+= dfs(nums, t - nums[i],  target, i+1);

        return res;

    }
}
