class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[][] a = new int[nums.length][2];
        for(int i=0;i<nums.length;i++){
            a[i][0] = nums[i];
            a[i][1] = i;
        }
        Arrays.sort(a,Comparator.comparingInt(b->b[0]));

        int l = 0;
        int r = nums.length-1;
        
        while(l<=r){
            if(a[l][0]+a[r][0] ==  target){
                return new int[]{Math.min(a[l][1],a[r][1]),Math.max(a[l][1], a[r][1])};
            }else if(a[l][0]+ a[r][0]> target){
                r=r-1;
            }else{
                l=l+1;
            }
        }
        return new int[0];
        
    }
}
