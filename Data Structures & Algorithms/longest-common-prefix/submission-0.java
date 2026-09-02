class Solution {
    public String longestCommonPrefix(String[] strs) {

        String ex = strs[0];

        StringBuilder sb = new StringBuilder();


        for(int i = 0; i < ex.length(); i++){
            char c = strs[0].charAt(i);
            for(int j =0; j  < strs.length; j++){
                if(i >= strs[j].length() || strs[j].charAt(i) != c){
                    return sb.toString();
                }

            }
            sb.append(c);
        }

        return sb.toString();
        
    }
}