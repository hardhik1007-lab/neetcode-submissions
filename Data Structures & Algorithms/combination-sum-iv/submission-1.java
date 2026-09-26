class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] memo = new int[target];
        Arrays.fill(memo, -1);

        return dfs(0, nums, target, memo);
        
    }

    public int dfs(int sum, int[] nums, int target, int[] memo){
        if(sum == target){
            return 1;
        }

        if(sum > target){
            return 0;
        }

        if(memo[sum] != -1){
            return memo[sum];
        }
        int res = 0;
        for(int n : nums){
            res += dfs(sum + n, nums, target,memo);
        }

        memo[sum] = res;
        return res;
    }
}