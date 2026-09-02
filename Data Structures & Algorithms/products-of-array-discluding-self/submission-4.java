class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prev = new int[nums.length];
        int prod = 1;
        for(int i = 0; i< nums.length; i++){
            prev[i] = prod;
            prod = prod * nums[i];
        }

        int prod_nxt = 1;
        for(int i = nums.length -1 ; i>=0;i--){
            prev[i] = prev[i] * prod_nxt;
            prod_nxt = prod_nxt * nums[i];

        }
        return prev;
    }
}  
