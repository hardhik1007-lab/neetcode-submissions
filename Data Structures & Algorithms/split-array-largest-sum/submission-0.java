class Solution {
    public int splitArray(int[] nums, int k) {

        int max= 0;
        int total = 0;

        for(int num : nums){
            max = Math.max(max, num);
            total += num;
        }

        int l = max;
        int r = total;

        while(l <= r){
            int m = l + (r-l) / 2;
            int maximum = m;
            int subarrays = 1;
            

            for(int num : nums){

                if(maximum - num < 0){
                    subarrays++;
                    maximum = m;
                }
                maximum -= num;
            }

            if(subarrays <= k){
                r = m - 1;
            }else{
                l = m + 1;
            }
        
        }

        return l;
        
    }
}