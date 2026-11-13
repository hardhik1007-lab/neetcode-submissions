class Solution {

    List<String> res = new ArrayList<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> sentence = new ArrayList<>();
        int[] memo = new int[s.length()];
        dfs(sentence, wordDict, s, 0, memo);
        return res;
        
        
    }

    public boolean dfs(List<String> sentence, List<String> dict, String s, int i, int[] memo){
        if(i == s.length()){
            StringBuilder temp = new StringBuilder();
            for(int j = 0; j < sentence.size(); j++){
                if(j == 0){
                    temp.append(sentence.get(j));
                    continue;
                }
                temp.append(" ");
                temp.append(sentence.get(j));  
                
            }
            res.add(temp.toString());   
            return true;
        }

        if(memo[i] == -1){
            return false;
        }

        
        boolean ans = false;
        int x = 0;
        for(String w : dict){
            
            if(i + w.length() <= s.length() && s.substring(i, i + w.length()).equals(w)){
                
                sentence.add(w);
                ans = dfs(sentence, dict, s, i + w.length(), memo);
                if(ans){
                    x = 1;
                }
                sentence.remove(sentence.size() - 1);
            }
        }
        
        if(x == 0){
            memo[i] = -1;
        }else{
            memo[i] = 1;
        }
       
        return x == 1;

    }
}