class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length;i++){
            map.put(nums[i],i);
        }
        for(int i=0; i<nums.length;i++){
            int want = target - nums[i];
            if(map.containsKey(want) && map.get(want)!=i){
                return new int[]{Math.min(i,map.get(want)),Math.max(i,map.get(want))};
            }
        }
        return new int[0];
    }
}
