class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        //initiaite dp values to 1 at end of t
        for(int i = 0; i < s.length() + 1; i++){
            dp[i][t.length()] = 1;
        }
        for(int i = s.length()-1; i >= 0; i--){
            for(int j =t.length()-1; j>=0; j--){
                if(s.charAt(i) == t.charAt(j)){
                    dp[i][j] = dp[i+1][j] + dp[i+1][j+1];
                }else{
                    dp[i][j] = dp[i+1][j];
                }
            }
        }

        return dp[0][0];
        
    }
    public int dfs(String s, String t, int i, int j, int[][] memo){
        if(j >= t.length()){
            return 1;
        }
        if(i >= s.length()){
            return 0;

        }
        if(memo[i][j] != -1){
            return memo[i][j];
        }
        int res = 0;
        if(s.charAt(i) == t.charAt(j)){
           res +=  dfs(s,t,i+1, j, memo) + dfs(s,t,i+1,j+1, memo);
        }else{
            res += dfs(s,t,i+1,j,memo);
        }
        memo[i][j] = res;

        return res;

    }
}
