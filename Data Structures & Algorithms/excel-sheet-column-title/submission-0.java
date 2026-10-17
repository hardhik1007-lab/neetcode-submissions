class Solution {
    public String convertToTitle(int columnNumber) {

        StringBuilder sb = new StringBuilder();
        int n = columnNumber;
        
        
        while(n > 0){
            n = n - 1;
            sb.append((char)('A' + (n%26)));
            n = n/26;
            
        }
        sb.reverse();
        return sb.toString();
    }
}