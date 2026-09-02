class Solution {
    public void nextPermutation(int[] nums) {
        int i  = nums.length-2;
        while(i>=0 && nums[i]>=nums[i+1]){
            
            i--;
        }
        int j  = nums.length -1;
        if(i>=0){
            while(nums[j]<=nums[i]){
            j--;
        }
        swap(i,j,nums);

        }
        
        
        int l = i+1, r = nums.length -1;

        while(l<r){
            swap(l,r,nums);
            l++;
            r--;
        }
    }


    public void swap(int i, int j , int[] nums){
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
} 