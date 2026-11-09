class Solution {

    List<String> res = new ArrayList<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> sentence = new ArrayList<>();
        dfs(sentence, wordDict, s, 0);
        return res;
        
        
    }

    public void dfs(List<String> sentence, List<String> dict, String s, int i){
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
            return;
        }

        

        for(String w : dict){
            
            if(i + w.length() <= s.length() && s.substring(i, i + w.length()).equals(w)){
                ;
                sentence.add(w);
                dfs(sentence, dict, s, i + w.length());
                sentence.remove(sentence.size() - 1);
            }
        }


    }
}