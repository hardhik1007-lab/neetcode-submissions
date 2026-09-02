class Solution {
    public void sortColors(int[] nums) {
        int red0 = 0;
        int white1 = 0;
        int blue2 = 0;
        for(int i =0; i<nums.length; i++){
            if(nums[i] == 0){
                red0++;

            }else if(nums[i] == 1){
                white1++;

            }else{
                blue2++;
            }
        }
        for(int i =0; i<nums.length; i++){
            if(i < red0){
                nums[i] = 0;
            }else if(i < red0 + white1){
                nums[i] = 1;

            }else{
                nums[i] = 2;
            }
        }
    }
}