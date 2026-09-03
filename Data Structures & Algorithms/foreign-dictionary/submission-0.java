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

        Queue<Character> q = new ArrayDeque<>();
        HashMap<Character, Integer> indegree = new HashMap<>();

        for(char c: map.keySet()){
            indegree.put(c,0);
        }
        for(List<Character> value : map.values()){
            for(char c : value){
                indegree.put(c,indegree.get(c) + 1);
            }
        }
        for(char c: indegree.keySet()){
            if(indegree.get(c) == 0){
                q.add(c);
            }
        }

        StringBuilder sb = new StringBuilder();

        while(!q.isEmpty()){
            char cur = q.poll();
            sb.append(cur);
            for(char c : map.get(cur)){
                indegree.put(c, indegree.get(c) - 1);
                if(indegree.get(c) == 0){
                    q.add(c);
                }
            }
        }
        if(sb.length() != map.size()){
            return "";
        }

        return sb.toString();


      
    }
}
