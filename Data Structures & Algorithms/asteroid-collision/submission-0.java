class Solution {
    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> stack = new Stack<>();
        for(int ast : asteroids){
            if(ast > 0){
                stack.push(ast);
            }else{
                boolean explode = false;
                while(!stack.isEmpty() && stack.peek() > 0 && ast < 0){
                    int top = stack.peek();
                    
                     
                    if(top >  Math.abs(ast)){
                        explode = true;
                        break;
                    }else if(top < Math.abs(ast)){
                        stack.pop();
                    }else if(top == Math.abs(ast)){
                        stack.pop();
                        explode = true;
                        break;
                    }

                }

                if(!explode){
                    stack.push(ast);
                }
            }
        }

        int[] res = new int[stack.size()];
        for(int i = res.length - 1; i >= 0; i--){
            res[i] = stack.pop();
        }   

        return res;
        
    }
}