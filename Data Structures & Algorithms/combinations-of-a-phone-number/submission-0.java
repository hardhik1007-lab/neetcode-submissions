class Solution {
    List<String> res= new ArrayList<>();
    String[] digitToChar = {
            "", "", "abc", "def", "ghi", "jkl",
            "mno", "qprs", "tuv", "wxyz"
        };
    public List<String> letterCombinations(String digits) {
        StringBuilder curr = new StringBuilder("");
        
        if (digits.isEmpty()) return res;
        dfs(0, curr, digits );
        return res;
        
    }

    public void dfs(int i, StringBuilder curr, String digits){
        if(curr.length() == digits.length()){
            res.add(curr.toString());
            return;
        }

        String chars = digitToChar[digits.charAt(i) - '0'];

        for(char c: chars.toCharArray()){
            curr.append(c);
            dfs(i+1,curr, digits);
            curr.deleteCharAt(curr.length() - 1);
        }


    }
}
