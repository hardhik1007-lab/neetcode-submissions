class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i = 0; i< nums.length; i++){
           sum+=nums[i];
        }
        if(sum%2 == 1){
            return false;
        }
        return dfs(nums, 0, 0, sum);


    }

    boolean dfs(int[] nums, int s, int i,int sum){
        if(s == sum/2){
            return true;
        }
        if(i>=nums.length){
            return false;
        }
        

        return dfs(nums, s+ nums[i], i+1,sum) || dfs(nums, s, i+1,sum);


    }
}
