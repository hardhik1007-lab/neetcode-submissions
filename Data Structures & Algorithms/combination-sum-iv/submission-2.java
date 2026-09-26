class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];

        dp[target] = 1;

        for(int i = target; i >= 0; i--){
            for(int n : nums){
                if(i + n <= target){
                    dp[i] += dp[i + n];
                }
            }

        }

        return dp[0];

        

        
        
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