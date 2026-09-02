class Solution {
    public boolean isValid(String s) {
        if(s.length()%2!=0){
            return false;

        }

        Deque<Character> stack = new ArrayDeque<>();
        for(int i=0; i<s.length();i++){
            char c = s.charAt(i);
            if(c=='(' || c=='{' || c=='['){
                stack.push(c);
            }else{
                if(stack.isEmpty()){
                    return false;
                }else{
                    if (c==')' && stack.pop()!='(') return false;
                    if (c=='}' && stack.pop()!='{') return false;
                    if (c==']' && stack.pop()!='[') return false;
                }
            }
        }
        return stack.isEmpty();
        
        
    }
}
