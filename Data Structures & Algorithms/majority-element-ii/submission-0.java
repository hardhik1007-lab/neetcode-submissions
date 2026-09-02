class Solution {
    public List<Integer> majorityElement(int[] nums) {

        int n = nums.length;
        int count1 = 0, count2 = 0;
        int candidate1 = 0, candidate2 = 0;

        for(int i = 0; i < n; i++){
            if(count1 == 0 && nums[i] != candidate2){
                candidate1 = nums[i];
                
            }else if(count2 == 0 && nums[i] != candidate1){
                candidate2 = nums[i];
                
            }

            if(nums[i] == candidate1){
                count1++;
            }else if(nums[i] == candidate2){
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