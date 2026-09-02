class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        Arrays.sort(candidates);
        List<Integer> curr= new ArrayList<>();
        dfs(0,curr,0,candidates,target);
        return res;


        
    }
    public void dfs(int i, List<Integer> curr, int total,int[] candidates, int target ){
        if(total == target){
            res.add(new ArrayList<>(curr));
            return;
        }
        if(i>=candidates.length|| total> target){
            return;
        }
        curr.add((candidates[i]));
        dfs(i+1, curr, total + candidates[i], candidates, target);

        curr.remove(curr.size()-1);

        while(i+1<candidates.length && candidates[i] == candidates[i+1]){
            i++;
        }
        dfs(i+1, curr, total, candidates, target);

    }
}
