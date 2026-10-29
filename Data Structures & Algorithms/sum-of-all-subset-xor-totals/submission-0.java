class Solution {
    int total = 0;
    public int subsetXORSum(int[] nums) {
        dfs(0, nums, 0);
        return total;
    }

    public void dfs(int i, int[] nums, int sum){
        if(i == nums.length){
            total += sum;
            return;
        }

        dfs(i+1, nums, sum);
        dfs(i+1, nums, nums[i] ^ sum);
    }
}