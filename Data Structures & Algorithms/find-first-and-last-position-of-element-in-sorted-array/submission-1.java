class Solution {
    public int[] searchRange(int[] nums, int target) {

        int l = binarySearch(nums, target, true);
        int r = binarySearch(nums,target,false);

        return new int[]{l,r};


        
    }

    public int binarySearch(int[] nums, int target, boolean leftBias){
        int l = 0;
        int r = nums.length - 1;
        
        int m = -1;

        while(l<=r){
            int mid = l + (r - l) / 2;
            if(target < nums[mid]){
            r = mid - 1;
            }else if(target > nums[mid]){
                l = mid + 1;
            }else{
                m = mid;
                if(leftBias){
                    r = mid - 1;
                }else{
                    l = mid + 1;
                }
            }

        }

        return m;

        
    }
}