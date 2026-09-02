class Solution {
    public int climbStairs(int n) {
        int[] memo = new int[n+1];
        for(int i = 0; i< n+1; i++){
            memo[i] = -1;
        }
        return dfs(0,n, memo);
        
    }

    public int dfs(int i, int n, int[] memo){
        if(i == n){
            return 1;
        }
        if(i>n){
            return 0;
        }
        if(memo[i] != -1){
            return memo[i];
        }

        int res = dfs(i+1,n, memo) + dfs(i+2, n, memo);
        memo[i] = res;
        return res;

        
    }
}
