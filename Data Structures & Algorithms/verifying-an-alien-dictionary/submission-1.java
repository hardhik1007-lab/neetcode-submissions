class Solution {
    public boolean isAlienSorted(String[] words, String order) {

        int[] rank = new int[26];
        for(int i = 0; i < order.length(); i++){
            char c = order.charAt(i);
            rank[c - 'a'] = i;
        }

        for(int i = 0; i < words.length - 1; i++){
            String word1 = words[i];
            String word2 = words[i+1];

            int len = Math.min(word1.length(), word2.length());
            boolean found = false;

            for(int j = 0; j < len; j++){
                if(word1.charAt(j) != word2.charAt(j)){
                    int pos1 = rank[word1.charAt(j) - 'a'];
                    int pos2 = rank[word2.charAt(j) - 'a'];
                    if(pos1 > pos2){
                        return false;
                    }
                    found = true;
                    break;
                }
            }
            if(!found && word1.length() > word2.length()){
                return false;
            }
        }

        return true;
        
    }
}