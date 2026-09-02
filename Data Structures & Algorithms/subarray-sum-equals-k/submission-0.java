class Solution {
    public int subarraySum(int[] nums, int k) {

        
        HashMap<Integer, Integer> map = new HashMap<>();

        int preSum = 0;
        int count = 0;

        for(int i = 0; i < nums.length; i++){
            map.put(preSum,map.getOrDefault(preSum,0) +1);
            preSum += nums[i];
            if(map.containsKey(preSum - k)){
                count += map.get(preSum - k);
            } 

        }
        return count;
        


        
    }
}