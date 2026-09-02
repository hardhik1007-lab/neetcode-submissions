class Solution {
    public int minDistance(String word1, String word2) {

        int n = word1.length();
        int  m = word2.length();
        int f = Math.max(n,m);

        int[][] memo = new int[f][f];
        for(int i = 0; i < f; i++){
            for(int j = 0; j < f; j++){
                memo[i][j] = -1;
            }
        }
        return dfs(word1, word2,0,0, memo);
    }

    public int dfs(String word1, String word2, int i, int j, int[][] memo){
        if(i >= word1.length()){
            return word2.length() - j;
        }
        if(j >= word2.length()){
            return word1.length() - i;
        }
        if(memo[i][j] != -1){
            return memo[i][j];
        }
        int res =0;

        if(word1.charAt(i) == word2.charAt(j)){
            res = dfs(word1, word2, i+1, j+1,memo);
        }else{
            //insert 
            int insert = dfs(word1,word2,i,j+1,memo);
            int delete = dfs(word1,word2,i+1,j,memo);
            int replace =  dfs(word1,word2,i+1,j+1,memo);
            res = 1 + Math.min(insert, Math.min(delete, replace));
        }
        memo[i][j] = res;
        return res;
    }
}
