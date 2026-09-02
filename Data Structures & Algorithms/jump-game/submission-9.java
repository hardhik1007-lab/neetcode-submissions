class Solution {
    public boolean canJump(int[] nums) {

        boolean[] dp = new boolean[nums.length];
        int farthest = 0;
        for(int i = 0; i < nums.length -  1; i++){
            if(i <= farthest){
                farthest = Math.max(farthest, i + nums[i]);
            }else{
                return false;
            }
        }
        return farthest >= nums.length - 1;
    
        
    }
    
}
