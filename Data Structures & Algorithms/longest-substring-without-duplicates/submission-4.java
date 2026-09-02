class Solution {
    public int lengthOfLongestSubstring(String s) {

        int l = 0;
        int r=0;
        int res = 0;
        Set<Character> map = new HashSet<>();
        while(r<s.length()){
            if(map.isEmpty() || !map.contains(s.charAt(r))){
                map.add(s.charAt(r));
                res = Math.max(res,r-l+1);
                
                r++;
            }else{
                while(map.contains(s.charAt(r))){
                    map.remove(s.charAt(l));
                    
                    l++;
                }
            }
           
        }
        return res;
        
    }
}
