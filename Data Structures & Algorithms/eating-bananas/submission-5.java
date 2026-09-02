class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        int sum = 0;
        
        for (int i = 0; i<piles.length;i++){
            if(piles[i]>max){
                max = piles[i];
                
            }
        }
        int l =1;
        int r = max;
        
        int res =r;
        while(l<=r){
            int k = l + (r-l)/2;
            int time =0;

            for(int i =0; i<piles.length;i++){
                time+=(piles[i]+k-1)/k;
            }
            if(time<=h){
                res = k;
                r = k-1;
            }else{
                l=k+1;
            }
        }
        return res;





        
    }
}
