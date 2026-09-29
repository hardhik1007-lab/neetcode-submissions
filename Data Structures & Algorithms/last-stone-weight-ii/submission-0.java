class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;

        for(int i = 0; i < stones.length; i++){
            sum += stones[i];
        }

        int[][] memo = new int[stones.length][sum * 2 + 1];
        for(int i = 0; i < stones.length; i++){
            Arrays.fill(memo[i], -1);
        }

        return dfs(0, 0, stones, memo, sum);
        
    }

    public int dfs(int i, int diff,  int[] stones, int[][] memo, int sum){
        if(i == stones.length){
            return Math.abs(diff);
        }



        if(memo[i][diff + sum] != -1){
            return memo[i][diff + sum];

        }

        int res = Math.min(dfs(i+1, diff + stones[i], stones, memo, sum), dfs(i+1, diff - stones[i], stones, memo, sum));

        memo[i][diff + sum] = res;

        return res;
    }
}