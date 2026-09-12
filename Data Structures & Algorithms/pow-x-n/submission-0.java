class Solution {
    public double myPow(double x, int n) {

        if(x == 0){
            return 0;
        }

        if(n == 0){
            return 1;
        }
        long m = n;

        if(n < 0){
            m = -m;
        }
        double ans  = dfs(x, m);

        if(n < 0){
            return 1/ans;

        }else{
            return ans;
        }


        
    }

    public double dfs(double x, long n){
        if(n == 1){
            return x;
        }

        double res = dfs(x, n/2);
        if(n % 2 == 1){
            res = res * res * x;
        }else{
            res= res * res;
        }
        return res;
    }
}
