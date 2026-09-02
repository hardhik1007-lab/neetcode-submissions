class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] prices = new int[n];
        for(int i = 0; i < n; i++){
            if(i != src){
                prices[i] = Integer.MAX_VALUE;
            }
        }
        int count = 0;
        
        while(count < k+1){
            int[] temp = prices.clone();

            for(int[] flight : flights){
                int from = flight[0];
                int to = flight[1];
                int price = flight[2];

                if(prices[from] != Integer.MAX_VALUE){
                    temp[to] = Math.min(temp[to], prices[from] + price );
                }
            }
            count++;
            prices = temp;
        }

        return prices[dst] != Integer.MAX_VALUE ? prices[dst] : -1;

    }
}
