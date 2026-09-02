class Solution {
    public int numDistinct(String s, String t) {
        int[][] memo = new int[s.length()][t.length()];
        for(int i = 0; i < s.length(); i++){
            for(int j =0; j < t.length(); j++){
                memo[i][j]= -1;
            }
        }

        return dfs(s,t,0,0,memo);
        
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
