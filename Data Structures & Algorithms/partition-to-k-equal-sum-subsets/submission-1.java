class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {

        int[] arr = new int[k];
        int total = 0;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = temp;
        }
        for(int i = 0; i < nums.length; i++){
            total += nums[i];
        }
        if(total % k != 0){
            return false;
        }
        int target = total / k;

        return dfs(0, nums, arr, target);
    }

    public boolean dfs(int i, int[] nums, int[] arr, int target){

        if(i == nums.length){
            for (int a = 1; a < arr.length; a++) {
                if (arr[a] != arr[0]) {
                    return false;
                }
            }
            return true;
    
        }

        HashSet<Integer> set = new HashSet<>();
        for(int j = 0; j < arr.length; j++){
            if(set.contains(arr[j])){
                continue;
            }
            if(arr[j] + nums[i] > target){
                continue;
            }

            set.add(arr[j]);
            arr[j] += nums[i];
            if(dfs(i+1, nums, arr, target)){
                return true;
            }
            arr[j] -= nums[i];
        }

        return false;
        
    }
}