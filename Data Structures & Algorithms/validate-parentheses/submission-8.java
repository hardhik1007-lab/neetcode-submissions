class Solution {
    public boolean isValid(String s) {
        if(s.length()%2!=0){
            return false;

        }
        Deque<Character> stack = new ArrayDeque<>(); 
        int count =0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(' || s.charAt(i)=='{' || s.charAt(i)=='['){
                stack.push(s.charAt(i));
                count++;
            }else if(!stack.isEmpty()){
                if(s.charAt(i)==')' ){
                    if(stack.pop() == '('){
                    
                        continue;
                    }else{
                        return false;
                    }
                }else if(s.charAt(i)=='}'){
                    if(stack.pop() == '{'){
                        continue;
                    }else{
                        return false;
                    }
                }else{
                    if(stack.pop() == '['){
                        continue;
                    }else{
                        return false;
                    }
                    
                }
            }
            
        }
        if(count==0 || !stack.isEmpty()){
            return false;
        }
        return true;
        
        
    }
}
