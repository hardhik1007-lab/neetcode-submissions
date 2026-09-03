class Solution {
    public String foreignDictionary(String[] words) {

        HashMap<Character, List<Character>> map = new HashMap<>();
        for(String word : words){
            for(char c : word.toCharArray()){
                if(!map.containsKey(c)){
                    map.put(c, new ArrayList<>());
                }
            }
        }

        for(int i = 0; i < words.length - 1; i++){
            String word1 = words[i];
            String word2 = words[i+1];

            int len = Math.min(word1.length(), word2.length());
            boolean found = false;

            for(int j = 0; j < len; j++){
                
                if(word1.charAt(j) != word2.charAt(j)){
                    map.get(word1.charAt(j)).add(word2.charAt(j));
                    found = true;
                    break;
                }
                
            }
            if(!found && word1.length() > word2.length()){
                    return "";
                }

        }
        HashMap<Character, Integer> state = new HashMap<>();
        for(char c: map.keySet()){
            state.put(c,0);
        }


        StringBuilder path = new StringBuilder();
        for(char c: map.keySet()){
            
            if(state.get(c) == 0 && !dfs(c, map, state, path )){
                return ""; 
            }
        }

        path.reverse();
        return path.toString();


      
    }

    public boolean dfs(char c, HashMap<Character, List<Character>> map, HashMap<Character, Integer> state, StringBuilder path){
        if(state.get(c) == 1){
            return false;
        }
        if(state.get(c) == 2){
            return true;
        }

        state.put(c, 1);
        for(char i : map.get(c)){
            if(!dfs(i, map, state,path)){
                return false;
            }
        }
        state.put(c, 2);
        path.append(c);
        return true;
        
    }
}
