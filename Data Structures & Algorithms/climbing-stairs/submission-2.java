class Solution {
    public int climbStairs(int n) {

        int[] cache = new int[n];
        for(int i = 0; i<n;i++){
            cache[i] = -1;
        }
        return dfs(cache,0,n);
    }

    public int dfs(int[] cache, int i, int n){

        if(i>n){
            return 0;
        }
        if(i== n){
            return 1;
        }
        if(cache[i]!=-1){
            return cache[i];
        }
        cache[i] = dfs(cache, i+1,n) + dfs(cache,i+2,n);
        return cache[i];

    }
}
