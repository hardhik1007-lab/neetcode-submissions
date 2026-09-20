class Solution {
    public int[] sortArray(int[] nums) {

        dfs(nums, 0, nums.length - 1);
        return nums;
        
    }

    public void dfs(int[] nums, int left, int right){
        if(left >= right){
            return;
        }



        //sort them
        int j = left;
        for(int i = left; i < right; i++){
            if(nums[i] < nums[right]){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }

        int temp2 = nums[right];
        nums[right] = nums[j];
        nums[j] = temp2;

        dfs(nums, left,j - 1);
        dfs(nums, j + 1, right);

        return;
    }
}