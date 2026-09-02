class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] memo = new int[text1.length()][text2.length()];
        for(int i = 0; i < text1.length(); i++){
            for(int j = 0 ; j <text2.length(); j++){
                memo[i][j] = -1;
            }
        }
        return dfs(0,0,text1,text2, memo);
        
    }

    public int dfs(int i, int j, String text1, String text2,int[][] memo){
        if(i == text1.length() || j == text2.length()){
            return 0;
        }
        if(memo[i][j] != -1){
            return memo[i][j];
        }
        int res = 0;
        if(text1.charAt(i) == text2.charAt(j)){
            res  =  1 + dfs(i+1, j+1,text1,text2,memo);
            
        }else{
            res = Math.max(dfs(i+1,j,text1,text2,memo), dfs(i, j+1,text1,text2,memo));
        }
        memo[i][j] = res;
        return res;

    }
}
