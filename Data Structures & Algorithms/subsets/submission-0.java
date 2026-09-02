class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subs = new ArrayList<>();

        dfs(nums,0,res, subs);
        return res;

        
    }

    public void dfs(int[] nums, int i, List<List<Integer>> res, List<Integer> subs){
        if(i>=nums.length ){
            res.add(new ArrayList<>(subs));
            return;
        }
        subs.add(nums[i]);
        dfs(nums,i+1,res,subs);
        subs.remove(subs.size() - 1);
        dfs(nums,i+1, res, subs);

    }
}
