class Solution {
    List<List<Integer>> res = new ArrayList<>();
    
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> list = new ArrayList<>();
        dfs(1,k,n,list);
        return res;
        
    }
    public void dfs(int i, int k, int n, List<Integer> list){
	if(list.size() ==k){
		res.add(new ArrayList<>(list));
        return;
	}
	if(i > n){
		return;
	}

    for(int j = i; j <= n; j++){
        list.add(j);
        dfs(j+1, k,n, list);
        list.remove(list.size() - 1);

    }

	
    }
}