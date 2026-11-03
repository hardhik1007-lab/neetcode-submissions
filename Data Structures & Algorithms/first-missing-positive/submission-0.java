class Solution {
    public int firstMissingPositive(int[] nums) {

        int n = nums.length;

        for(int i = 0; i < n; i++){
            while(nums[i] != i + 1 && nums[i] <= n && nums[i] > 0 && nums[i] != nums[nums[i] - 1]){
                swap(i, nums[i] - 1, nums);
            }
        }

        for(int i = 0; i < n; i++){
            if(nums[i] != i + 1){
                return i+1;
            }
        }

        return n + 1;
        
    }

    public void swap(int i, int j, int[] nums){
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}