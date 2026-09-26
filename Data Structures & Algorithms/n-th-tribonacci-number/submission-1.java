class Solution {
    public int tribonacci(int n) {

        int[] memo = new int[n+1];
        Arrays.fill(memo, -1);

        return dfs(n, memo);
        
        
    }

    public int dfs(int n, int[] memo){
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 1;
        }

        if(memo[n] != -1){
            return memo[n];
        }

        int res = dfs(n-1,memo) + dfs(n-2,memo) + dfs(n-3,memo);
        memo[n]= res;
        return res;
    }
}