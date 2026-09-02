class Solution {
    public int maxCoins(int[] nums) {
        int[] num = new int[nums.length +2];
        int[][] memo = new int[nums.length][nums.length];
        for(int i =0; i < nums.length; i++){
            for(int j = 0; j < nums.length; j++){
                memo[i][j] = -1;
            }
        }
        for(int i = 0; i < num.length; i++){
            if(i == 0 || i == num.length -1){
                num[i] = 1;
            }else{
                num[i] = nums[i-1];
            }
            
        }

        return dfs(num,1,num.length - 2, memo);
        
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
