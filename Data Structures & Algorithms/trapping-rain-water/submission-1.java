class Solution {
    

   
    public int trap(int[] height) {

        int total = 0;

        for(int i = 0; i<height.length; i++){
            int l = i;
            int height_l_max = height[i];
            int r = i;
            int height_r_max = height[i];
            while(l>=0){
                height_l_max = Math.max(height_l_max, height[l]);
                l--;
            }
            while(r<height.length){
                height_r_max = Math.max(height_r_max,height[r]);
                r++;
            }
            if(height_l_max <= height[i] || height_r_max <= height[i]){
                continue;
            }

            total += Math.min(height_l_max, height_r_max) - height[i];

        }

        return total;
        
    }
}
