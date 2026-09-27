class Solution {
    
    public int integerBreak(int n) {

        int[] memo = new int[n + 1];

        return dfs(n, memo);
        
    }

    public int dfs(int n, int[] memo){

        if(n == 1){
            return 1;
        }


        if(memo[n] != 0){
            return memo[n];
        }
        
        int res = 1;
        for(int i = 1; i < n; i++){

            res = Math.max(res, i * (n-i));

            res = Math.max(res, i * dfs(n-i, memo));

            
        }

        memo[n] = res;

        return res;

    }
}