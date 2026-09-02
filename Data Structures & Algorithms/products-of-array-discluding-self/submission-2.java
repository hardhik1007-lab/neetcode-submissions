class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int prev =1;
        int[] prefarr =new int[nums.length];
        for(int i = 0;i<nums.length;i++){
            prefarr[i] = prev;
            prev*=nums[i];
        }
        int suf = 1;
        int[] sufarr =new int[nums.length];
        for(int i= nums.length-1;i>=0;i--){
            sufarr[i] = suf;
            suf*=nums[i];
        }
        int[] res =new int[nums.length];
        for(int i = 0;i<nums.length;i++){
            res[i] = prefarr[i] * sufarr[i];
        }
        return res;
    }
}  
