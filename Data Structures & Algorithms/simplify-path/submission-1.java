class Solution {
    public String simplifyPath(String path) {

        Stack<String> stack = new Stack<>();

        String[] parts = path.split("/");

        for(String str : parts){
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

        StringBuilder res  = new StringBuilder();

        for(String dir : stack){
            
            res.append('/');
            res.append(dir);
        }

        if(res.length() == 0){
            return "/";
        }

        return res.toString();
        
    }
}