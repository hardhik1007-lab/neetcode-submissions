class Solution {
    public String minWindow(String s, String t) {

        Map<Character,Integer> fre = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for(char c: t.toCharArray()){
            fre.put(c,fre.getOrDefault(c,0) +1);
        }
        int l =0;
        int r =0;
        int have =0;
        int need = fre.size();
        int[] res = {-1,-1};
        int resLen = Integer.MAX_VALUE;

        while(r<s.length()){
            char c = s.charAt(r);

            window.put(c, window.getOrDefault(c,0)+1);
            if(fre.containsKey(c) && fre.get(c) == window.get(c)){
                have++;
            }
            while(have==need){
                if((r-l+1)<resLen){
                    resLen = r-l+1;
                    res[0] = l;
                    res[1] = r;
                }
                char left = s.charAt(l);
                window.put(left,window.get(left) - 1);
                if(fre.containsKey(left) && window.get(left)<fre.get(left)){
                    have--;
                }
                l++;

            }
            r++;

        }
        return resLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] +1);
        
    }
}
