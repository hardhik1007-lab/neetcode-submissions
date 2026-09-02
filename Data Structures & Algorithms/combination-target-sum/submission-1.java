class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer> curr = new ArrayList<>();
        res= new ArrayList<>();
        

       
        dfs(0,curr,0,nums,target);
        return res;
        
    }
     public void dfs(int i, List<Integer> curr, int total,int[]nums,int target){
             if(total==target){
                res.add(new ArrayList<>(curr));
                return;
            }
            if( i > nums.length-1||total>target ){
                return;

            }
           
            curr.add(nums[i]);
            dfs(i,curr,total+nums[i],nums,target);
            curr.remove(curr.size() -1);
            dfs(i+1, curr,total,nums,target);

        }
    
}
