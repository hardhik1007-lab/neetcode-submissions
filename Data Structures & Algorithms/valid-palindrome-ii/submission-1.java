class Solution {
    public boolean validPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        int count = 0;
        while(l < r){
            if(s.charAt(l) == s.charAt(r)){

                l++;
                r--;
            }else{
                return isPalindrome(l+1,r,s) || isPalindrome(l,r-1,s);

            }

        }
        return true;
        
    }

    public boolean isPalindrome(int l, int r, String s){
        while(l < r){
            if(s.charAt(l) == s.charAt(r)){
                l++;
                r--;
            }else{
                return false;
            }
        } 

        return true;
    }
}