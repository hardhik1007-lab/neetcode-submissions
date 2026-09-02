class Solution {

    
    public int findTargetSumWays(int[] nums, int target) {

        HashMap<Integer, Integer>[] dp = new HashMap[nums.length + 1];
        for(int i=0;i<=nums.length; i++){
            dp[i] = new HashMap<>();

        }

        dp[0].put(0,1);
        for(int i = 0; i<nums.length; i++){
            for(Map.Entry<Integer, Integer> entry : dp[i].entrySet()){
                int total = entry.getKey();
                int count = entry.getValue();
                dp[i+1].put(total+nums[i],dp[i+1].getOrDefault(total+nums[i],0) + count);
                dp[i+1].put(total-nums[i],dp[i+1].getOrDefault(total-nums[i],0) + count);
            }

        }
        return dp[nums.length].getOrDefault(target,0);

        
    
        
       
       
    }
}
