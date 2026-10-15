class Solution {
    public String predictPartyVictory(String senate) {

        StringBuilder sb = new StringBuilder(senate);

        char c = dfs(sb, 0);
        if(c == 'R'){
            return "Radiant";
        }else{
            return "Dire";
        }
        
    }

    public Character dfs(StringBuilder sb, int i){

        int n = sb.length();

        for(int k = 1; k <= n; k++){
            int idx = (i + k) % n;

            if(sb.charAt(idx) != sb.charAt(i)){
                sb.deleteCharAt(idx);
                int nn = sb.length();
                if(idx < i){
                    return dfs(sb, i % nn);
                }else{
                    return dfs(sb, (i+1) % nn);
                }
            }
            
        }

        return sb.charAt(i);
    }
}