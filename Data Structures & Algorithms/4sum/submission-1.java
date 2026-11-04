class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            for(int j = i + 1; j < nums.length; j++){
                if(j > i+1 && nums[j] == nums[j-1]){
                    continue;
                }
                int l = j+1;
                int r = nums.length - 1;
                long rem = (long)target - nums[i] - nums[j];
                while(l < r){
                    long sum = nums[l] + nums[r];
                    if( sum > rem){
                        r--;
                    }else if(sum < rem){
                        l++;
                    }else{
                        res.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        r--;
                        l++;
                        while(l < r && nums[l-1] == nums[l]){
                        l++;
                        }
                        while(l < r && nums[r+1] == nums[r]){
                            r--;
                        }
                    }

                    

                }
            }
        }

        return res;
        
    }
}