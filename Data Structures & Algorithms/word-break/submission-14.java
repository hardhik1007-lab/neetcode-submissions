class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int[] memo = new int[s.length()];
        return dfs(s, wordDict, 0, memo);
    }

    public boolean dfs(String s, List<String> wordDict, int i, int[] memo){
        if(i == s.length()){
            return true;
        }
        if(memo[i] == 1){
            return true;
        }else if(memo[i] == -1){
            return false;
        }
        
        
        

        for(String w : wordDict){
            //for every word in the wordDict

            
            // if from index i, we can form the word w, increase the i and call dfs.
            if((i + w.length() <= s.length()) && s.substring(i, i + w.length()).equals(w)){
                boolean res = dfs(s, wordDict, i + w.length(), memo);
                if(res){
                    memo[i] = 1;
                    return res;
                }
            }
            // return dfs( i + word.length())

        }
        memo[i] = -1;
        return false;
    }
}
