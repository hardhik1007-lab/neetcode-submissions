class Solution {
    public int[] searchRange(int[] nums, int target) {

        int l = biSearch(nums, target, true);
        int r = biSearch(nums, target, false);

        return new int[]{l,r};
        
    }

    public int biSearch(int[] nums, int target, boolean leftBias){
        int l = 0;
        int r = nums.length -1; 
        int i = -1;
        while(l<=r){

            int mid = l + (r-l) / 2;

            if(nums[mid] > target){
                r = mid - 1;

            }else if(nums[mid] < target){
                l = mid + 1;
            }else{
                i = mid;
                if(leftBias){
                    r = mid - 1;
                }else{
                    l = mid + 1;
                }
            }

        
        } 
        return i;
    }
}