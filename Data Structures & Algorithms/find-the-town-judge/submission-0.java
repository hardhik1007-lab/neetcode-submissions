class Solution {
    public int findJudge(int n, int[][] trust) {

        int[] res = new int[n+1];

        for(int[] t : trust){
            res[t[0]] -= 1;
            res[t[1]] += 1;
        }

        for(int i = 0; i <= n; i++){
            if(i != 0 && res[i] == n-1){
                return i;
            }
        }

        return -1;
        
    }
}