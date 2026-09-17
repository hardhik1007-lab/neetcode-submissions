class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int max = 0;
        int total = 0;
        for(int w : weights){
            max = Math.max(max, w);
            total += w;

        }
        int l = max;
        int r = total;

        int ans = Integer.MAX_VALUE;

        while(l <= r){
            int capacity = l + (r- l)/ 2;
            int ships = 1;
            int cap = capacity;

            for(int w : weights){
                if(cap - w <0){
                    ships++;
                    cap = capacity;
                }
                cap -= w;
            }

            if(ships <= days){
                ans = Math.min(ans, capacity);
                r = capacity-1;
            }else{
                l = capacity +1;

            }

        }
        return ans;
        
    }
}