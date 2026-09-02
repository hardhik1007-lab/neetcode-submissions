class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int prev =1;
        int[] res = new int[nums.length];

        for(int i = 0; i<nums.length;i++){
            res[i] = prev;
            prev*=nums[i];
        }
        int post = 1;
        for(int i = nums.length-1; i>=0;i--){
            res[i] = post*res[i];
            post*=nums[i];
        }
        return res;
    }
}  
