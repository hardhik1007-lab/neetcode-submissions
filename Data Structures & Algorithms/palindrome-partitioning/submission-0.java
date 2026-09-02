class Solution {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> partition(String s) {
        List<String> curr = new ArrayList<>();
        dfs(0,curr,s);
        return res;

        
    }

    public void dfs(int i, List<String> curr,String s){
        if(i>=s.length()){
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int j = i; j<s.length();j++){
            
            if(isPal(s,i,j)){
                curr.add(s.substring(i,j+1));
                dfs(j+1, curr,s);
                curr.remove(curr.size()-1);
            }
        }
    }

    public boolean isPal(String s,int i, int j){
        
        
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
