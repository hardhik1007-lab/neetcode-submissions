class Solution {
    public boolean canJump(int[] nums) {

        boolean[] dp = new boolean[nums.length];
        int goal = nums.length - 1;
        for(int i = nums.length - 2; i >=0; i--){
            if(i + nums[i] >= goal){
                goal = i;
            }
            
        }
        return goal == 0;

       
        
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
