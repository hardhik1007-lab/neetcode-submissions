class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m+1][n+1];
        dp[m][n] = true;

        for(int i = m; i >= 0; i--){
            for(int j = n-1; j >=0; j-- ){
                boolean match = i < m && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
                if(j+1 < p.length() && p.charAt(j+1) == '*'){
                    dp[i][j] = dp[i][j+2];
                    if(match){
                        dp[i][j] = dp[i][j+2] || dp[i+1][j];
                    }
                }else if (match){
                    
                    dp[i][j] = dp[i+1][j+1];
                }
            }
        }

        return dp[0][0];
    }
    public boolean dfs(int i, int j, String s, String p, Boolean[][] memo){
        
        if(j >= p.length()){
            return i >= s.length();
        }
        if(memo[i][j] != null){
            return memo[i][j];
        }
        boolean firstmatch = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
        boolean res= false;

        if(j+1 < p.length() && p.charAt(j+1) == '*'){
            if(firstmatch){
                res=  dfs(i+1,j,s,p,memo) || dfs(i,j+2,s,p,memo);
            }else{
                res = dfs(i,j+2,s,p,memo);
            }
        }else{
            if(firstmatch){
                res=  dfs(i+1,j+1,s,p,memo);
            }else{
                res = false;
            }
        }
        memo[i][j] = res;
        return res;





        
    }
}
