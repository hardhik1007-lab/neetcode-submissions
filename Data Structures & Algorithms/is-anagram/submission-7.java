class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()){
            return false;
        }

        int[] map = new int[26];

        for(int i = 0; i < s.length(); i++){

            map[s.charAt(i) - 'a'] +=1;
            map[t.charAt(i) - 'a'] -=1;
        }

        for(int i = 0; i < 26; i++){
            if(map[i] != 0){
                return false;
            }
        }

        return true;

    }
}
