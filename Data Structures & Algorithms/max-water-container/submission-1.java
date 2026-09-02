class Solution {
    public int maxArea(int[] heights) {

        int l = 0;
        int r = heights.length - 1;
        int res = -1;

        while(l<=r){
            res= Math.max(res,(r-l)* (Math.min(heights[l], heights[r])));
            if(heights[l] < heights[r]){
                l++;
            }else{
                r--;
            }
        }

        return res;

        
    }
}
