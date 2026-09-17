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
            int currentsum = 0;
            int subarrays = 1;
            

            for(int num : nums){
                currentsum += num;
                if(currentsum > m){
                    subarrays++;
                    currentsum = num;
                }
                
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