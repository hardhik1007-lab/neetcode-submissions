class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] memo = new int[text1.length()+1][text2.length()+1];
        for(int i=0;i<text1.length();i++){
            Arrays.fill(memo[i],-1);
        }
        return dfs(memo,text1,text2,0,0);
        
         
        
    }

    public int dfs(int[][] memo, String text1, String text2, int i, int j){

        if(i<0 || j<0 || i>text1.length()-1 || j>text2.length()-1){
            return 0;
        }
        if(memo[i][j]!=-1){
            return memo[i][j];
        }
        if(text1.charAt(i)==text2.charAt(j)){
            memo[i][j] = dfs(memo, text1,text2, i+1,j+1) + 1;
        }else{
            memo[i][j] = Math.max(dfs(memo, text1,text2, i,j+1),dfs(memo, text1,text2, i+1,j));
        }

        return memo[i][j];
        
    }
}
