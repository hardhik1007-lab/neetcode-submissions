class Solution {
    public int stoneGameII(int[] piles) {

        int n = piles.length;

        Integer[][] memo = new Integer[n+1][n+1];

        

        
        return dfs(0,piles,1, memo);
        
        
    }

    public int dfs(int i, int[] piles, int m, Integer[][] memo){

        if(i >= piles.length){
            return 0;
        }

        if(memo[i][m] != null){
            return memo[i][m];
        }

        int res = Integer.MIN_VALUE;

        int sum = 0;
        for(int k = i; k < piles.length; k++){
            sum += piles[k];
        }

        for(int j = i; j < piles.length && j - i + 1 <= 2*m; j++){
            
            int newm = Math.max(m , j-i +1);

            res = Math.max(res, sum - dfs(j+1, piles, newm, memo));

             
            

        }

        memo[i][m] = res;

        return res;

    }
}