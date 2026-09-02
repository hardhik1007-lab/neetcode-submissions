class Solution {
    public int minCostClimbingStairs(int[] cost) {

        int[] res = new int[cost.length];

        for(int i = cost.length-1; i>=0;i--){
            if(i>cost.length - 2){
                res[i] = cost[i];
            }else if(i==cost.length-2){
                res[i] = Math.min(cost[i] + res[i+1] , cost[i]);
            }else{
                res[i] = Math.min(cost[i] + res[i+1] , cost[i] + res[i+2]);
            }
            
        }

        return Math.min(res[0], res[1]);
        
    }
}
