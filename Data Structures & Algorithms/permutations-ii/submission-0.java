class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {

        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        boolean[] seen= new boolean[nums.length];
        dfs(nums, list, seen);
        return res;
        
    }

    public void dfs(int[] nums, List<Integer> list, boolean[] seen ){
        if(list.size() == nums.length){
            res.add(new ArrayList<>(list));
        }

        for(int i = 0; i < nums.length; i++){
            if(seen[i]){
                continue;
            }
            if(i > 0 && nums[i] == nums[i-1] && !seen[i-1]){
                continue;
            }
            list.add(nums[i]);
            seen[i] = true;
            dfs(nums, list, seen);
            list.remove(list.size() - 1);
            seen[i] = false;
        }
    }
}