class Solution {
    public String decodeString(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c != ']'){
                stack.push(c);
            }else{
                StringBuilder sb = new StringBuilder();
                while(stack.peek() != '['){
                    sb.insert(0, stack.pop());// this is being addded in reverse order
                }
                stack.pop();// delete the '['
                //make the digit
                StringBuilder sb1 = new StringBuilder();
                while(!stack.isEmpty() && Character.isDigit(stack.peek())){
                    sb1.insert(0, stack.pop());
                }
                
                int no = Integer.parseInt(sb1.toString());
                StringBuilder repeat = new StringBuilder();

                for(int j = 0; j < no; j++){
                    repeat.append(sb);
                }

                for(int k = 0; k < repeat.length(); k++){
                    stack.push(repeat.charAt(k));
                }
                 
            }
        }

        StringBuilder rem = new StringBuilder();

        while(!stack.isEmpty()){
            rem.insert(0, stack.pop());

        }

        return rem.toString();

        // if the stack is not empty add all the remainng to the string.
    }
}