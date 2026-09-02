class Solution {
    public int jump(int[] nums) {
        int[] m = new int[nums.length];
        for(int i =nums.length -2; i>=0; i--){
            int min_min = 10000;
            int idx = Math.min(nums[i] + i, nums.length-1);
            for(int j = idx; j>i; j-- ){
                int min = m[j] + 1;
                min_min = Math.min(min, min_min);
                
            }
            m[i] = min_min;
        }
        return m[0];
    }
}
