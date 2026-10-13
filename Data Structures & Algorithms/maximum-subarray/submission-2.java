class Solution {
    public int maxSubArray(int[] nums) {

        
        int curmax = 0;
        int max = -1;

        for(int i = 0; i < nums.length; i++){
            curmax += nums[i];

            max = Math.max(max, curmax);
            if(curmax < 0){
                curmax = 0;
            }
            
        }

        return max;
        
    }
}
