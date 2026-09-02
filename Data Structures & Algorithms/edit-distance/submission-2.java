class Solution {
    public int minDistance(String word1, String word2) {

        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for(int i = word1.length(); i>=0; i--){
            dp[i][word2.length()] = word1.length() - i;
        }
        for(int j = word2.length(); j>=0; j--){
            dp[word1.length()][j] = word2.length() - j;
        }
        for(int i = word1.length()-1; i >= 0; i--){
            for(int j = word2.length() - 1; j >= 0; j--){
                if(word1.charAt(i) == word2.charAt(j)){
                    dp[i][j] = dp[i+1][j+1];
                }else{
                    dp[i][j] = 1 + Math.min(dp[i+1][j+1],Math.min(dp[i+1][j],dp[i][j+1]));
                }
            }
        }
        return dp[0][0];
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
