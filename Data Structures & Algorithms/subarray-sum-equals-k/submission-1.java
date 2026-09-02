class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int res= 0;
        int prefix = 0;
        map.put(0,1); 

        for(int i = 0; i < nums.length; i++){
            prefix += nums[i];
            if(map.containsKey(prefix - k)){
                res += map.get(prefix - k);
            }
            map.put(prefix,map.getOrDefault(prefix,0) + 1);
            


        }
        return res;
        
    }
}