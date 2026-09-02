class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> curr = new ArrayList<>();
        dfs(0, curr, nums);
        return res;

        
    }

    public void dfs(int i, List<Integer> curr, int[] nums ){
        if(i>=nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }
        curr.add(nums[i]);
        dfs(i+1, curr, nums);
        curr.remove(curr.size()-1);
        while(i+1<nums.length && nums[i]==nums[i+1]){
            i++;
        }
        dfs(i+1, curr, nums);
    }
}
