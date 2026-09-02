class Solution {
    List<String> res= new ArrayList<>();
    String[] digitToChar = {
            "", "", "abc", "def", "ghi", "jkl",
            "mno", "qprs", "tuv", "wxyz"
        };
    public List<String> letterCombinations(String digits) {
        String curr = "";
        
        if (digits.isEmpty()) return res;
        dfs(0, curr, digits );
        return res;
        
    }

    public void dfs(int i, String curr, String digits){
        if(curr.length() == digits.length()){
            res.add(curr.toString());
            return;
        }

        String chars = digitToChar[digits.charAt(i) - '0'];

        for(char c: chars.toCharArray()){
            
            dfs(i+1,curr+c, digits);
            
        }


    }
}
