class Solution {
    public int trap(int[] height) {
        int l = 0;
        int r = height.length -1;
        int maxL = height[l];
        int maxR = height[r];
        int total = 0;
        while(l<r){
            if(maxL < maxR){
                l++;
                maxL = Math.max(maxL, height[l]);
                if(maxL - height[l] > 0){
                    total += maxL - height[l];
                }
                
            }else{
                r--;
                maxR = Math.max(maxR, height[r]);
                if(maxR - height[r] > 0){
                    total += maxR - height[r];
                }
            }
        }

        return total;
    }
}
