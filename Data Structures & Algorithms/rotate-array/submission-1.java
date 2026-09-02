class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;

        int l = 0;
        int r = nums.length - 1;
        reverse(nums,l,r);
        reverse(nums, 0, k-1);
        reverse(nums,k,r);


        
    }

    public void reverse(int[] nums, int i, int j){
        while(i < j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}