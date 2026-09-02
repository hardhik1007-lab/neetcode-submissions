class Solution {
    public int jump(int[] nums) {
        int l=0,r = 0;
        int res = 0;
        for(int i = 0 ; i<nums.length - 1; i++){
            r = Math.max(r, nums[i] + i);
            if(i == l){
                res++;
                l = r;
            }

        }
        return res;
    }
}
