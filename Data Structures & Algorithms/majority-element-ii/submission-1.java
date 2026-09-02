class Solution {
    public List<Integer> majorityElement(int[] nums) {

        int n = nums.length;
        int count1 = 0, count2 = 0;
        int candidate1 = 0, candidate2 = 0;

        for(int i = 0; i < n; i++){
            if(nums[i] == candidate1){
                count1++;
            }else if(nums[i] == candidate2){
                count2++;
            }else if(count1 == 0){
                candidate1 = nums[i];
                count1++;
            }else if(count2 == 0){
                candidate2 = nums[i];
                count2++;
            }else{
                count1--;
                count2--;
            }

        }
        count1 =0;
        count2 =0;

        for(int i = 0; i < n; i++){
            if(nums[i] == candidate1){
                count1++;
            }
            if(nums[i] == candidate2){
                count2++;
            }
        }

        List<Integer> res= new ArrayList<>();
        if(count1 > n/3){
            res.add(candidate1);
        }
        if(count2 > n/3){
            res.add(candidate2);
        }
        
        return res;
        
        
    }
}