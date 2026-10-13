class Solution {
    public int maxSubarraySumCircular(int[] nums) {

        int curmin = 0;
        int min = Integer.MAX_VALUE;
        int total = 0;

        for(int i = 0; i < nums.length; i++){
            total += nums[i];
            curmin += nums[i];
            min = Math.min(min, curmin);
            if(curmin > 0){
                curmin = 0;
            }
            
        }

        int curmax = 0;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++){
            curmax += nums[i];
            max = Math.max(max, curmax);
            if(curmax < 0){
                curmax = 0;
            }
            
        }
        if(max < 0){
            return max;
        }

        return Math.max(max, total - min);




        
    }
}