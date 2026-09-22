class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();

        int i = 0;
        while(i < path.length()){
            while(i < path.length() && path.charAt(i) == '/'){
                i++;

            }
            StringBuilder sb = new StringBuilder();
            while(i < path.length() && path.charAt(i) != '/'){
                sb.append(path.charAt(i));
                i++;
            }
            String str = sb.toString();

            if(str.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
                
            }else if(str.equals(".")){
                continue;
            }else if(str.equals("")){
                continue;
            }
            else{
                stack.push(str);
            }
        }


        if(stack.isEmpty()){
            return "/";
        }
        StringBuilder res = new StringBuilder();
        while(!stack.isEmpty()){
            String temp = stack.pop();
            for(int j = temp.length() - 1; j >= 0; j--){
                res.append(temp.charAt(j));
            }
            res.append('/');
        }

        res.reverse();
        return res.toString();

        
    }
}