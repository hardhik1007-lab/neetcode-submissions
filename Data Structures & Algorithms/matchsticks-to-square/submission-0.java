class Solution {
    public boolean makesquare(int[] matchsticks) {

        Arrays.sort(matchsticks);

        for (int i = 0; i < matchsticks.length / 2; i++) {
            int temp = matchsticks[i];
            matchsticks[i] = matchsticks[matchsticks.length - 1 - i];
            matchsticks[matchsticks.length - 1 - i] = temp;
        }
        int[] sq = new int[4];
        int total = 0;
        for(int i = 0; i < matchsticks.length; i++){
            total += matchsticks[i];
        }
        if(total % 4 != 0){
            return false;
        }

        int target = total/4;

        return dfs(sq, matchsticks, 0, target);

        
    }

    public boolean dfs(int[] sq, int[] arr, int i, int target){
        if(i == arr.length){
            if(sq[0] == sq[1] && sq[1] == sq[2] && sq[2] == sq[3]){
                return true;
            }
            return false;
        }
        HashSet<Integer> set = new HashSet<>();
        for(int j = 0; j < 4; j++){
            if(set.contains(sq[j])){
                continue;
            }
            set.add(sq[j]);
            
            
            if(sq[j] + arr[i] <= target){
                sq[j] += arr[i];
                if(dfs(sq, arr, i+1, target)){
                    return true;
                }
                sq[j] -= arr[i];
            }
            
        }

        return false;
    }
}