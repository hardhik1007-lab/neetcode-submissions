class Solution {
    public boolean isMatch(String s, String p) {
        Boolean[][] memo = new Boolean[s.length() + 1][p.length()];
        
        return dfs(0,0,s,p,memo);
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
