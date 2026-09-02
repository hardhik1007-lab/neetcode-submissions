class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l =0, r =0;
        HashSet<Character> set = new HashSet<>();
        int maxLen = 0;

        while(l<s.length() && r<s.length()){
            while(set.contains(s.charAt(r))){
                set.remove(s.charAt(l));
                l++;
                
            }
            set.add(s.charAt(r));
            maxLen = Math.max(maxLen, r-l +1);
            r++;

        }

        return maxLen;
        
    }
}
