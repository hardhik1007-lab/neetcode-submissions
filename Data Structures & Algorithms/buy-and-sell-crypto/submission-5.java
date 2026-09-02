class Solution {
    public int maxProfit(int[] prices) {
        int buyprice =10000;
        
        int maxprofit = 0;
        for(int i =0; i<prices.length;i++){
            int curprofit = prices[i]-buyprice;
            if(maxprofit<curprofit){
                maxprofit = curprofit;
            }
            if(buyprice>prices[i]){
                buyprice = prices[i];
            }
            
        }  
        return maxprofit;
        
    }
}
