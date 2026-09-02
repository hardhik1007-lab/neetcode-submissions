class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < stones.length; i++){
            maxHeap.add(stones[i]);
        }

        while(maxHeap.size() > 1){
            int largest = maxHeap.poll();
            int second  = maxHeap.poll();

            if(largest - second >  0 ){
                maxHeap.add(largest - second);
            }
        }

        if(maxHeap.isEmpty()){
            return 0;
        }else{
            return maxHeap.poll();
        }

        
    }
}
